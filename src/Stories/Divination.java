package Stories;

import GUI.Stories;
import Game.Player;

public class Divination extends Story {
    @Override
    public void playStory(Player player){
        this.player = player;
        builder = "";
        GUI = new Stories(this.player, "Welcome to the Magical Creature Forest", "img/magicalforest.jpg");
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
                        builder += character;
                        GUI.printStory(builder);
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
