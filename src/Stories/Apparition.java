package Stories;

import GUI.StoryBuilder;
import Game.Player;
import Game.Waiter;

/**
 * This is an inherited class from {@link Story} where a story is slowly built and is played in {@link GUI.Stories}.
 */
public class Apparition extends Story {
    /**
     * In this method, the first important thing is to set everything to the zero-state, since the same object can be played multiple times in
     * one session, and it would cause bugs. Then the {@link GUI.Stories} is created using {@link StoryBuilder}. After that, the actual story-printing
     * begins. A new {@link Thread} is created to play the story. In the thread {@link Story#string_builder}, the story is built letter by
     * letter and then by calling "printStory(string_builder)" method is printed in the {@link GUI.Stories} GUI. After that if the whole story
     * was printed, the {@link Player#addPoints()} is called to increment the player's score. If the player skips the story, no points are added.
     * In the end the {@link #done} is set to true, to notify the class which is responsible for continuing to the next part of the game, that
     * this class finished it's work.
     * @param player the player
     * @throws InterruptedException is thrown if there is a problem in {@link Waiter} class
     */
    @Override
    public void playStory(Player player) throws InterruptedException {
        this.player = player;
        string_builder = "";
        i = 0;
        GUI = new StoryBuilder()
        .setPlayer(player)
        .setSuper("Welcome to the Ghostly Hallways")
        .setImagePath("img/ghostly.jpg")
        .build();
        Thread storyThread = new Thread(new Runnable() {
            @Override
            public void run() {
                story = "<html><div style='text-align:center'>Welcome to the Ghostly Hallways, where the spirits of Hogwarts roam free. <br> I am Nearly Headless Nick, Gryffindor's resident ghost, and I'll be your guide on this spectral journey.<br>" +
                        "<br>" +
                        "In my class, you'll learn about the ancient art of Apparition - the ability to transport oneself from one place to <br> another in an instant. It's a skill that requires a great deal of concentration, focus, and bravery.<br>" +
                        "<br>" +
                        "But that's not all. You'll also learn about the ghosts of Hogwarts - the many spirits that haunt these <br> halls, each with their own unique stories and personalities. We'll explore the history and <br> mythology of ghosts, and you'll learn how to interact with them in a respectful and appropriate way.<br>" +
                        "<br>" +
                        "And let me tell ya, interacting with ghosts can be quite tricky. They have a tendency to be <br> mischievous, and they don't always appreciate mortals poking around in their business. <br> But if you're willing to show them respect and courtesy, they can be invaluable sources of knowledge and wisdom.<br>" +
                        "<br>" +
                        "In my class, we'll be spending a lot of time wandering through these ghostly hallways, exploring the nooks and crannies <br> of Hogwarts that most students never even knew existed. You'll learn to navigate the twists and turns of these spectral <br> passages, and you'll gain a deeper understanding of the magic that permeates this ancient school.<br>" +
                        "<br>" +
                        "So, if you're ready to embark on a journey through the world of apparition <br> and ghosts, then welcome to my class. Together, we'll explore the mysteries of the spirit <br> world and gain a new appreciation for the magic that surrounds us all.</div></html>";
                while (i < story.length()) {
                    char character = story.charAt(i);
                    if (!GUI.getPause()) {
                        string_builder += character;
                        GUI.printStory(string_builder);
                        i++;
                    }
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                GUI.setReadWhole();
            }
        });
        storyThread.start();

        GUI.ifDone();
        if (GUI.getRead())
            this.player.addPoints();
        this.done = true;
    }
}
