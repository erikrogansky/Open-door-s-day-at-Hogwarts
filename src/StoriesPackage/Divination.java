package StoriesPackage;

import GUIPackage.StoryBuilder;
import GUIPackage.StoryGUI;
import GamePackage.Player;
import GamePackage.Waiter;

/**
 * This is an inherited class from {@link Story} where a story is slowly built and is played in {@link StoryGUI}.
 */
public class Divination extends Story {
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
        GUI  = new StoryBuilder()
        .setPlayer(player)
        .setSuper("Welcome to the Divination Classroom")
        .setImagePath("img/divination.jpg")
        .build();
        Thread storyThread = new Thread(() -> {
            story = "<html><div style='text-align:center'>Welcome to the Divination Classroom, my dear " + player.getGender('s') + ". I am Professor <br> Sybill Trelawney, and I'll be your guide on this journey of self-discovery.<br>" +
                    "<br>" +
                    "In my class, you'll learn about the ancient art of Divination - the ability to see beyond the veil of reality and peer into the <br> mysteries of the future. It's a skill that requires a great deal of intuition, imagination, and sensitivity to the world around us.<br>" +
                    "<br>" +
                    "But be warned, Divination is not for the faint of heart. The ability to see into <br> the future is a rare and powerful gift, and it comes with its own unique set of challenges and dangers.<br>" +
                    "<br>" +
                    "In my class, you'll spend countless hours pouring over crystal balls, tarot cards, and other mystical <br> tools, seeking insights into the mysteries of fate and destiny. You'll learn to interpret signs and <br> omens, and you'll gain a deeper understanding of the interconnectedness of all things.<br>" +
                    "<br>" +
                    "But let me tell you, the path of the diviner is not an easy one. You'll face skepticism and disbelief from those who doubt <br> the existence of the mystical realm, and you'll need to have the courage to stand by your beliefs and convictions.<br>" +
                    "<br>" +
                    "But if you're willing to take on the challenge, the rewards of studying Divination are <br> immeasurable. You'll gain a deep understanding of yourself and the world around you, <br> and you'll learn to see the hidden patterns and connections that exist beneath the surface of reality.<br>" +
                    "<br>" +
                    "So, if you're ready to embark on a journey of self-discovery through the mysteries of Divination, then welcome <br> to my class. Together, we'll explore the secrets of fate and destiny, and unlock the power of the mystical arts.</div></html>";
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
