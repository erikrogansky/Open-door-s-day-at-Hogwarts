package StoriesPackage;

import GUIPackage.StoryBuilder;
import GUIPackage.StoryGUI;
import GamePackage.Player;
import GamePackage.Waiter;

/**
 * This is an inherited class from {@link Story} where a story is slowly built and is played in {@link StoryGUI}.
 */
public class Runes extends Story {
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
        .setSuper("Welcome to the Archaic Library")
        .setImagePath("img/arlibrary.jpg")
        .build();
        Thread storyThread = new Thread(new Runnable() {
            @Override
            public void run() {
                story = "<html><div style='text-align:center'>Welcome to the Archaic Library, where the secrets of the ancient world are waiting to be uncovered. <br> I am Professor Bathsheda Babbling, and I teach Ancient Runes here at Hogwarts.<br>" +
                        "<br>" +
                        "In my class, you will learn about the ancient language of the runic alphabet, which has been used <br> for centuries to communicate ideas and convey knowledge. We'll explore the history and culture <br> of the civilizations that used this language, from the Norse to the Egyptians to the ancient Greeks.<br>" +
                        "<br>" +
                        "But make no mistake, Ancient Runes is not an easy subject. It requires a sharp mind, a keen eye <br> for detail, and a deep understanding of the nuances of language. You must be <br> willing to put in the time and effort to master this ancient art.<br>" +
                        "<br>" +
                        "In my class, you'll spend countless hours pouring over dusty tomes, deciphering ancient texts, and <br> piecing together the secrets of the past. And let me tell ya, it's not for the faint of heart.<br>" +
                        "<br>" +
                        "But the rewards of studying Ancient Runes are immeasurable. You'll gain a deep understanding of <br> the cultures and civilizations of the past, and you'll learn to appreciate <br> the beauty and complexity of language in all its forms.<br>" +
                        "<br>" +
                        "And if you're willing to put in the work, I promise you that the secrets of the ancient world will <br> be yours to uncover. So, if you're ready to embark on a journey of discovery through <br> the pages of history, then welcome to my class. Together, we'll unlock the <br> secrets of the past and gain a new appreciation for the power of language.</div></html>";
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
