package Stories;

import GUI.*;
import Game.Player;

public class MagicalTheory extends Story {
    @Override
    public void playStory(Player player){
        this.player = player;
        string_builder = "";
        i = 0;
        Builder builder = new Builder();
        builder.setPlayer(player);
        builder.setSuper("Welcome to the Magical Creature Forest");
        builder.setImagePath("img/magicalforest.jpg");
        GUI = builder.build();
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
