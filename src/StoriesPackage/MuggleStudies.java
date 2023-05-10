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
        .setSuper("Welcome to the Ghostly Hallways")
        .setImagePath("img/ghostly.jpg")
        .build();
        Thread storyThread = new Thread(new Runnable() {
            @Override
            public void run() {
                story = "<html><div style='text-align:center'><br>" +
                        "<br>" +
                        "<br>" +
                        "<br>" +
                        "<br>" +
                        "<br>" +
                        "<br>" +
                        "<br>" +
                        "<br>" +
                        "<br>" +
                        "<br>" +
                        "<br>" +
                        "</div></html>";
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
