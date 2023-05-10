package StoriesPackage;

import GUIPackage.StoryBuilder;
import GUIPackage.StoryGUI;
import GamePackage.Player;
import GamePackage.Waiter;

/**
 * This is an inherited class from {@link Story} where a story is slowly built and is played in {@link StoryGUI}.
 */
public class Potions extends Story {
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
        .setSuper("Welcome to the Potions Classroom")
        .setImagePath("img/potions.jpg")
        .build();
        Thread storyThread = new Thread(() -> {
            story = "<html><div style='text-align:center'>Welcome to the Potions Classroom, you insufferable dunderhead. I am Professor Severus Snape, and I teach Potions.<br>" +
                    "<br>" +
                    "In my class, you will learn the delicate art of potion-making. You will learn <br> how to follow instructions to the letter and how to measure ingredients with precision. You will also <br> learn the importance of patience and discipline when brewing even the simplest of potions.<br>" +
                    "<br>" +
                    "But let me make one thing clear. This is not a class for the lazy or the careless. If you do not pay attention and follow the <br> instructions to the letter, you will fail miserably. If you fail to show respect and obedience, you will be punished accordingly.<br>" +
                    "<br>" +
                    "Potions is a complex subject, and it requires a sharp mind and a quick wit. You must be able to <br> understand the intricacies of the various ingredients, their properties, and how they interact with each other. <br> You must also be able to follow my instructions without question, or face the consequences.<br>" +
                    "<br>" +
                    "In my class, we will brew potions that can cure ailments, transform objects, and even grant eternal life. But be <br> warned, the slightest mistake can lead to catastrophic consequences. You must be vigilant and focused at all times.<br>" +
                    "<br>" +
                    "And don't think that just because you are in my class that you are entitled to special <br> treatment. You will earn your grades, and you will earn them through hard work and dedication.<br>" +
                    "<br>" +
                    "So, if you are ready to put in the hard work and dedication required to succeed in my class, then welcome to Hogwarts <br> Potions. I promise you that if you survive my class, you will not just be a better potion maker, but you will also have <br> gained invaluable skills in discipline, attention to detail, and determination. Now, get to your cauldrons and start brewing.</div></html>";
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
