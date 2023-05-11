package StoriesPackage;

import GUIPackage.StoryBuilder;
import GUIPackage.StoryGUI;
import GamePackage.Player;
import GamePackage.Waiter;

/**
 * This is an inherited class from {@link Story} where a story is slowly built and is played in {@link StoryGUI}.
 */
public class Alchemy extends Story {
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
        .setSuper("Welcome to the Alchemy Classroom")
        .setImagePath("img/alchemy.jpg")
        .build();
        Thread storyThread = new Thread(() -> {
            story = "<html><div style='text-align:center'>Welcome to the Alchemy Classroom, my dear " + player.getGender('s') + ". I am the <br> headmaster Albus Dumbledore, and I'll be your guide on this journey into the secrets of the universe.<br>" +
                    "<br>" +
                    "Alchemy is an ancient art that seeks to understand the mysteries of creation and transformation. It is a discipline <br> that requires a keen intellect, a deep understanding of the natural world, and a willingness to explore the unknown.<br>" +
                    "<br>" +
                    "In my class, you'll learn about the history and philosophy of alchemy, and you'll explore <br> the many ways in which this discipline has influenced the course of human history. You'll gain a deep <br> appreciation for the power of transmutation, and you'll learn to wield this power with skill and precision.<br>" +
                    "<br>" +
                    "But be warned, alchemy is not a simple or easy discipline. It requires long hours of study <br> and contemplation, and it demands a level of focus and dedication that few are willing to give.<br>" +
                    "<br>" +
                    "In my class, you'll be working with a variety of materials and substances, exploring their properties and learning <br> to manipulate them in new and exciting ways. You'll be challenged to push the limits of what is possible, and <br> you'll be rewarded with a deep understanding of the fundamental forces that shape our world.<br>" +
                    "<br>" +
                    "But beyond the practical skills of alchemy lies a deeper truth - a truth that is at the heart of all magical and mystical <br> traditions. Alchemy is a path to self-discovery and enlightenment, a way of understanding the world and our place within it.<br>" +
                    "<br>" +
                    "So, if you're ready to embark on a journey of discovery through the mysteries of alchemy, then welcome to my <br> class. Together, we'll explore the secrets of the universe, and unlock the power of transformation and creation.</div></html>";
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
