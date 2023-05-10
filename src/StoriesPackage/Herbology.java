package StoriesPackage;

import GUIPackage.StoryBuilder;
import GUIPackage.StoryGUI;
import GamePackage.Player;
import GamePackage.Waiter;

/**
 * This is an inherited class from {@link Story} where a story is slowly built and is played in {@link StoryGUI}.
 */
public class Herbology extends Story {
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
        .setSuper("Welcome to the Hogwarts' Greenhouses")
        .setImagePath("img/greenhouse.jpg")
        .build();
        Thread storyThread = new Thread(() -> {
            story = "<html><div style='text-align:center'>Welcome to the Hogwarts Greenhouses, my young gardener! I am Professor Sprout, and I teach Herbology at Hogwarts.<br>" +
                    "<br>" +
                    "In my class, we will explore the wonders of the magical plant world. We will learn how to cultivate, care for, and <br> use the various herbs and plants that grow in our gardens. Herbology is a subject that requires patience, <br> diligence, and a keen eye for detail. But it's also a subject that can bring great joy and satisfaction.<br>" +
                    "<br>" +
                    "In my class, you will learn how to identify and cultivate various magical plants, including those <br> that are dangerous and those that are beneficial. We will also explore the magical properties <br> of these plants and how they can be used in potions and other magical applications.<br>" +
                    "<br>" +
                    "But let me warn you, my young gardeners. Herbology is not just about planting pretty flowers. It's about understanding the <br> intricate relationships between plants and their environment. It's about recognizing the subtle signs of disease and pests <br> and how to deal with them. It's about understanding the importance of soil and water quality and how to maintain them.<br>" +
                    "<br>" +
                    "In my class, we will work hard, and we will get our hands dirty. We will spend hours in the greenhouse, cultivating <br> and caring for our plants. We will also take field trips to the Forbidden Forest to gather rare and exotic specimens.<br>" +
                    "<br>" +
                    "But don't worry; I will be there to guide you every step of the way. I am a firm believer in the power of positive reinforcement <br> and encouragement. I will celebrate your successes and help you learn from your mistakes.<br>" +
                    "<br>" +
                    "So, if you're ready to get your hands dirty and learn the secrets of the magical plant world, then welcome to my class. <br> I promise you that you will leave here not just as a better gardener, but as a better person too.</div></html>";
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
