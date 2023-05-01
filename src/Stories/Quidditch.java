package Stories;

import GUI.*;
import Game.Player;

public class Quidditch extends Story {
    @Override
    public void playStory(Player player){
        this.player = player;
        GUI = new Stories(this.player, "Welcome to the Quidditch Stadium", "img/quidditch.png");
        Thread storyThread = new Thread(new Runnable() {
            @Override
            public void run() {
                story = "<html><div style='text-align:center'>Welcome to the Quidditch stadium, young athlete! I am Professor Sprout, <br> and I am in charge of the Quidditch team at Hogwarts.<br>" +
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
                for (char character : story.toCharArray()){
                    builder += character;
                    GUI.printStory(builder);
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
