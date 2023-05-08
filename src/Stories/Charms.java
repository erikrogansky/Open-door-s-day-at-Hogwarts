package Stories;

import GUI.*;
import Game.Player;

public class Charms extends Story {
    @Override
    public void playStory(Player player){
        this.player = player;
        string_builder = "";
        i = 0;
        Builder builder = new Builder();
        builder.setPlayer(player);
        builder.setSuper("Welcome to the Charms Classroom");
        builder.setImagePath("img/charms.jpg");
        GUI = builder.build();
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
