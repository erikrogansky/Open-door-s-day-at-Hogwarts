package Stories;

import GUI.StoryBuilder;
import Game.*;

/**
 * This is an inherited class from {@link Story} where a story is slowly built and is played in {@link GUI.Stories}.
 */
public class Transfiguration extends Story {
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
        i=0;
        GUI = new StoryBuilder()
        .setPlayer(player)
        .setSuper("Welcome to the Transfiguration classroom")
        .setImagePath("img/transfiguration.png")
        .build();
        Thread storyThread = new Thread(new Runnable() {
            @Override
            public void run() {
                story = "<html><div style='text-align:center'>Welcome to the Transfiguration classroom, young " + player.getGender('s') + ". I am Professor McGonagall, <br> and I am the head of the Transfiguration department at Hogwarts.<br>" +
                        "<br>" +
                        "Transfiguration is a complex branch of magic that involves transforming one object into another. It requires precision, <br> skill, and a deep understanding of the laws of magic. And let me tell you, it is not a subject for the faint-hearted.<br>" +
                        "<br>" +
                        "Here in my classroom, we focus on developing your abilities to transform objects into <br> animals or even completely different objects. You will learn how to transfigure a teapot into a tortoise <br> or a rat into a snuffbox. But beware, this is not a subject for those who lack discipline or patience.<br>" +
                        "<br>" +
                        "Transfiguration requires hours of practice and rigorous attention to detail. Every movement of your wand and every <br> incantation you utter must be precise. One wrong word, one flick of the wrist, and the consequences could be disastrous.<br>" +
                        "<br>" +
                        "But don't let that intimidate you. With hard work and dedication, you too can master <br> the art of Transfiguration. And once you do, the possibilities are endless. You can turn a rock into a bird, <br> a table into a human, and even make objects disappear altogether.<br>" +
                        "<br>" +
                        "But remember, with great power comes great responsibility. Transfiguration is not to be taken <br> lightly. It is a powerful branch of magic that must be used wisely and with caution.<br>" +
                        "<br>" +
                        "So, if you're up for the challenge and are willing to put in the effort, then welcome to my classroom. But be warned, <br> I have high expectations for my students. I expect nothing less than the best from each and every one of you.</div></html>";
                while (i < story.length() && done == null) {
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
