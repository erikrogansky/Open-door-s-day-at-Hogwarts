package StoriesPackage;

import GUIPackage.StoryBuilder;
import GUIPackage.StoryGUI;
import GamePackage.Player;
import GamePackage.Waiter;

/**
 * This is an inherited class from {@link Story} where a story is slowly built and is played in {@link StoryGUI}.
 */
public class Quidditch extends Story {
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
        .setSuper("Welcome to the Quidditch stadium")
        .setImagePath("img/quidditch.png")
        .build();
        Thread storyThread = new Thread(new Runnable() {
            @Override
            public void run() {
                story = "<html><div style='text-align:center'>Welcome to the Quidditch stadium, young athlete! I am Professor Rolanda Hooch, <br> and I am in charge of the Quidditch team at Hogwarts.<br>" +
                        "<br>" +
                        "Quidditch is not just a game. It's a way of life. It's about strength, agility, and teamwork. It's about pushing your limits <br> and reaching for the stars. And here at Hogwarts, we take Quidditch very seriously.<br>" +
                        "<br>" +
                        "In my Quidditch practices, we work hard, we sweat, and we strive to be the best. I demand nothing <br> but the best from my players. I expect discipline, commitment, and a hunger for victory. <br> If you're not willing to give it your all, then you're not cut out for the team.<br>" +
                        "<br>" +
                        "But don't let my strict demeanor fool you. I am full of energy, and I always bring my A-game to every practice. <br> I will push you to your limits, but I will also be your biggest cheerleader when you need it most. I will be there to <br> celebrate your victories and to pick you up when you fall.<br>" +
                        "<br>" +
                        "In my Quidditch practices, we focus on all aspects of the game. We work on improving your flying skills, your accuracy, <br> and your teamwork. We also practice various strategies and techniques to give you an edge on the field.<br>" +
                        "<br>" +
                        "But most importantly, we learn to trust each other. Quidditch is not a game that can be won alone. It takes a team effort <br> to come out on top. We learn to communicate, to rely on each other's strengths, and to cover each other's weaknesses.<br>" +
                        "<br>" +
                        "So, if you're ready to push yourself to your limits and to be part of an incredible team, then welcome to my Quidditch <br> stadium. I promise you that you will leave here not just as a better athlete, but as a better person too.</div></html>";
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
