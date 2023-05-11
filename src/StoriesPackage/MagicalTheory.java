package StoriesPackage;

import GUIPackage.StoryBuilder;
import GUIPackage.StoryGUI;
import GamePackage.*;

/**
 * This is an inherited class from {@link Story} where a story is slowly built and is played in {@link StoryGUI}.
 */
public class MagicalTheory extends Story {
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
        .setSuper("Welcome to the Library")
        .setImagePath("img/lib.jpg")
        .build();
        Thread storyThread = new Thread(() -> {
            story = "<html><div style='text-align:center'>Welcome to the Library, my dear " + player.getGender('s') + ". I am Professor Eleazar Fig, and <br> I'll be your guide on this journey through the fascinating world of Magical Theory.<br>" +
                    "<br>" +
                    "In my class, you'll learn about the many theoretical principles that underpin <br> the practice of magic. From the mechanics of spellcasting to the metaphysics of the <br> magical world, you'll gain a deep understanding of the fundamental laws that govern our craft.<br>" +
                    "<br>" +
                    "But be warned, the study of Magical Theory is not a simple or straightforward endeavor. It requires <br> a great deal of intellectual curiosity, creativity, and critical thinking. You'll need to be willing <br> to question your assumptions, to challenge your beliefs, and to explore new ideas.<br>" +
                    "<br>" +
                    "In my class, you'll explore the many ways in which the theoretical principles of magic can be <br> applied to practical spellcasting. You'll gain a deep appreciation for the ways in which theory and practice <br> are intertwined, and for the importance of a well-rounded magical education.<br>" +
                    "<br>" +
                    "But beyond the practical lessons of Magical Theory lies a deeper truth - a truth that is at the heart <br> of all magical practice. The study of Magical Theory is a path to understanding the essence of magic <br> itself, a way of seeing the world through a new lens. Through the study of Magical Theory, we come <br> to understand the very nature of magic, and the ways in which it shapes our lives.<br>" +
                    "<br>" +
                    "So, if you're ready to embark on a journey through the world of Magical Theory, then welcome to my class. Together, <br> we'll explore the many wonders of the magical world, and gain a deeper understanding of the nature of magic itself.</div></html>";
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
