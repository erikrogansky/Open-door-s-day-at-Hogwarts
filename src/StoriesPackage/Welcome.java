package StoriesPackage;

import GUIPackage.StoryBuilder;
import GUIPackage.StoryGUI;
import GamePackage.Player;
import GamePackage.Waiter;

/**
 * This is an inherited class from {@link Story} where a story is slowly built and is played in {@link StoryGUI}.
 */
public class Welcome extends Story {
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
        .setSuper("Welcome to Hogwarts")
        .setImagePath("img/welcome.jpg")
        .build();
        Thread storyThread = new Thread(new Runnable() {
            @Override
            public void run() {
                story = "<html><div style='text-align:center'>Greetings to all our guests and visitors on this special occasion of Open Door's Day at Hogwarts <br> School of Witchcraft and Wizardry. I am Albus Dumbledore, the headmaster of this venerable institution, <br> and I am delighted to have you here today.<br>" +
                        "<br>" +
                        "Hogwarts is more than just a school. It is a home, a family, a community of magical beings <br> who share a common passion for learning and discovery. Here, you will find not only classrooms and teachers,<br> but also friends and mentors challenges and adventures, secrets and mysteries.<br>" +
                        "<br>" +
                        "You are invited to explore our magnificent castle and grounds, <br> to witness the wonders of magic in action, to meet our talented and diverse students and staff, <br> and to experience the rich history and culture of our school. You will also have the opportunity <br> to learn more about our four houses: Gryffindor, Hufflepuff, Ravenclaw and Slytherin. <br> Each house has its own values, traditions and spirit that shape the character and destiny of its members.<br>" +
                        "<br>" +
                        "Whether you are a prospective student or parent, a curious muggle or a fellow wizard or witch, <br> we hope that you will enjoy your visit to Hogwarts and that you will leave with a sense of awe <br> and admiration for our magical world. We also hope that you will feel inspired by our motto:<br> \"Draco dormiens nunquam titillandus\", which means \"Never tickle a sleeping dragon\".<br>" +
                        "<br>" +
                        "Thank you for your attention and have a wonderful day!</div></html>";
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
