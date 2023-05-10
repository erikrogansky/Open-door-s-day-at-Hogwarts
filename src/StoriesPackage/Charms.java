package StoriesPackage;

import GUIPackage.StoryBuilder;
import GUIPackage.StoryGUI;
import GamePackage.Player;
import GamePackage.Waiter;

/**
 * This is an inherited class from {@link Story} where a story is slowly built and is played in {@link StoryGUI}.
 */
public class Charms extends Story {
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
        .setSuper("Welcome to the Charms Classroom")
        .setImagePath("img/charms.jpg")
        .build();
        Thread storyThread = new Thread(new Runnable() {
            @Override
            public void run() {
                story = "<html><div style='text-align:center'>Welcome to Hogwarts, young " + player.getGender('s') + "! I am Professor Flitwick, and I teach Charms at this prestigious school <br> of magic. Today is Open Door's day, and I am excited to show you the wonders of the Charms Classroom.<br>" +
                        "<br>" +
                        "Charms is one of the most important subjects taught at Hogwarts because it helps students <br> to develop their magical abilities. Charms allow us to perform spells that can do anything from <br> cleaning up a room to levitating objects to even protecting us from danger.<br>" +
                        "<br>" +
                        "Now, let me show you some of the basic spells that we teach here at Hogwarts. One of the first spells you will learn <br> is the Wingardium Leviosa. This spell allows you to levitate an object and move it around at your will. It requires a lot of <br> concentration and precise wand movements, but with practice, you'll be able to move even the heaviest objects with ease.<br>" +
                        "<br>" +
                        "Another spell that we teach is the Lumos. This spell creates a beam of light at the tip <br> of your wand, which can be useful for exploring dark areas or reading books at night. This spell is also handy <br> if you want to impress your friends with some cool wand tricks.<br>" +
                        "<br>" +
                        "We also teach spells that can protect you from danger. The Protego charm creates a magical shield <br> that can block spells and curses. It's a vital spell for defending yourself in battle.<br>" +
                        "<br>" +
                        "Charms classes at Hogwarts are always exciting because we're always learning new spells and discovering new ways to <br> use them. The possibilities are endless, and it's up to you to decide how to use your magical abilities for good.<br>" +
                        "<br>" +
                        "I hope you enjoyed this short introduction to Charms, " + player.getGender('s') + ". I look forward to seeing you in my classroom next year!</div></html>";
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
