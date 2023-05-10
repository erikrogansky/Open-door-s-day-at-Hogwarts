package StoriesPackage;

import GUIPackage.StoryBuilder;
import GUIPackage.StoryGUI;
import GamePackage.Player;
import GamePackage.Waiter;

/**
 * This is an inherited class from {@link Story} where a story is slowly built and is played in {@link StoryGUI}.
 */
public class Creatures extends Story {
    /**
     * In this method, the first important thing is to set everything to the zero-state, since the same object can be played multiple times in
     * one session, and it would cause bugs. Then the {@link StoryGUI} is created using {@link StoryBuilder}. After that, the actual story-printing
     * begins. A new {@link Thread} is created to play the story. In the thread {@link Story#string_builder}, the story is built letter by
     * letter and then by calling "printStory(string_builder)" method is printed in the {@link StoryGUI} GUI. After that if the whole story
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
        .setSuper("Welcome to the Magical Creature Forest")
        .setImagePath("img/magicalforest.jpg")
        .build();
        Thread storyThread = new Thread(() -> {
            story = "<html><div style='text-align:center'>Welcome to the Magical Creatures Forest, yer all! I'm Rubeus Hagrid, <br> Keeper of Keys and Grounds here at Hogwarts, and I teach the Care of Magical Creatures.<br>" +
                    "<br>" +
                    "In my class, you will learn about the wondrous and mysterious creatures that inhabit our world. From unicorns <br> to dragons, from centaurs to hippogriffs, we'll be exploring creatures that you never knew existed.<br>" +
                    "<br>" +
                    "But let me make one thing clear, these creatures are not pets. They are living beings with <br> unique personalities, habits, and needs. And you must learn to treat them with respect and care.<br>" +
                    "<br>" +
                    "In my class, we'll be spending a lot of time in the forest, where you'll learn to care for these creatures in their <br> natural habitat. You'll learn how to handle them safely, how to feed them, and how to understand their behaviors.<br>" +
                    "<br>" +
                    "And let me tell ya, some of these creatures can be dangerous if not handled <br> properly. That's why we'll be following strict safety protocols at all times.<br>" +
                    "<br>" +
                    "But don't worry, I'll be there with ya every step of the way. I have a deep love and respect for these creatures, <br> and I want to share that with ya all. And I promise you that if you show them the same love and respect <br> that I do, you'll be rewarded with a lifelong appreciation for the natural world.<br>" +
                    "<br>" +
                    "So, if you're ready to embark on an adventure through the Magical Creatures Forest, then welcome <br> to my class. I promise you that you'll leave here not just with a better understanding of magical creatures, <br> but with a deeper appreciation for the beauty and wonder of the natural world.</div></html>";
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
        });
        storyThread.start();

        GUI.ifDone();
        if (GUI.getRead())
            this.player.addPoints();
        this.done = true;
    }
}
