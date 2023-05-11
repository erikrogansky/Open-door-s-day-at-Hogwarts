package StoriesPackage;

import GUIPackage.StoryBuilder;
import GUIPackage.StoryGUI;
import GamePackage.Player;
import GamePackage.Waiter;

/**
 * This is an inherited class from {@link Story} where a story is slowly built and is played in {@link StoryGUI}.
 */
public class History extends Story {
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
        .setSuper("Welcome to the History classroom")
        .setImagePath("img/history.jpg")
        .build();
        Thread storyThread = new Thread(() -> {
            story = "<html><div style='text-align:center'>Welcome to the History Classroom, my dear " + player.getGender('s') + ". I am Professor Cuthbert Binns, <br> and I'll be your guide on this journey through the rich tapestry of human history.<br>" +
                    "<br>" +
                    "In my class, you'll learn about the many fascinating events and personalities that have <br> the course of human civilization. From the rise and fall of great empires to the struggles of everyday <br> people, you'll gain a deep understanding of the complexities of the human experience.<br>" +
                    "<br>" +
                    "But be warned, the study of history is not a simple or straightforward endeavor. <br> It requires a great deal of patience, perseverance, and attention to detail. You'll need to be <br> willing to dive deep into the archives, to pour over dusty tomes and ancient manuscripts,<br> to unravel the mysteries of the past and bring them to light.<br>" +
                    "<br>" +
                    "In my class, you'll explore the many ways in which the past has influenced the present, and you'll gain a deep <br> appreciation for the ways in which our world has been shaped by those who came before us.<br>" +
                    "<br>" +
                    "But beyond the practical lessons of history lies a deeper truth - a truth that is at <br> the heart of all human experience. History is a path to understanding, a way of seeing ourselves and <br> our place in the world with new eyes. Through the study of history, we come <br> to understand the human condition in all its beauty and complexity.<br>" +
                    "<br>" +
                    "So, if you're ready to embark on a journey through the annals of time, then welcome to my class. <br> Together, we'll explore the rich tapestry of human history, and gain a deeper understanding of the world around us.</div></html>";
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
