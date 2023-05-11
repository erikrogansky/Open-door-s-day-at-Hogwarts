package StoriesPackage;

import GUIPackage.StoryBuilder;
import GUIPackage.StoryGUI;
import GamePackage.Player;
import GamePackage.Waiter;

/**
 * This is an inherited class from {@link Story} where a story is slowly built and is played in {@link StoryGUI}.
 */
public class MuggleStudies extends Story {
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
        .setSuper("Welcome to the Muggle Storage")
        .setImagePath("img/muggle.jpg")
        .build();
        Thread storyThread = new Thread(() -> {
            story = "<html><div style='text-align:center'>Welcome to the Muggle Storage, my dear students. I am Professor Alecto Carrow, <br> and I'll be your guide on this journey through the world of Muggles.<br>" +
                    "<br>" +
                    "In my class, you'll learn about the many fascinating aspects of Muggle life, from their <br> technology and social structures to their customs and beliefs. You'll gain a deep understanding <br> of the ways in which Muggles see the world, and the ways in which their worldview differs from our own.<br>" +
                    "<br>" +
                    "But be warned, the study of Muggle culture is not for the faint of heart. You'll need to be willing to confront your <br> own biases and preconceptions, and to question the assumptions that you've been taught since childhood. <br> You'll need to be willing to step outside of your comfort zone, and to engage with the unfamiliar.<br>" +
                    "<br>" +
                    "In my class, you'll explore the many ways in which Muggles have influenced <br> our world, and the ways in which we have influenced theirs. You'll gain a deep appreciation <br> for the complexity of human culture, and for the ways in which we can learn from one another.<br>" +
                    "<br>" +
                    "But beyond the practical lessons of Muggle Studies lies a deeper truth - a truth that is at <br> the heart of all human experience. The study of Muggle culture is a path to empathy, a way <br> of seeing the world through the eyes of others. Through the study of Muggle Studies, we come to understand <br>  the many ways in which we are all connected, and the ways in which we can learn from one another.<br>" +
                    "<br>" +
                    "So, if you're ready to embark on a journey through the world of Muggles, then welcome to my class. <br> Together, we'll explore the many facets of Muggle life, and gain a deeper understanding of the world around us.</div></html>";
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
