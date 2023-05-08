package Stories;

import GUI.Builder;
import GUI.Stories;
import Game.Player;

public class Herbology extends Story {
    @Override
    public void playStory(Player player){
        this.player = player;
        string_builder = "";
        i = 0;
        Builder builder = new Builder();
        builder.setPlayer(player);
        builder.setSuper("Welcome to the Hogwarts' Greenhouses");
        builder.setImagePath("img/greenhouse.jpg");
        GUI = builder.build();
        Thread storyThread = new Thread(new Runnable() {
            @Override
            public void run() {
                story = "<html><div style='text-align:center'>Welcome to the Hogwarts Greenhouses, my young gardener! I am Professor Sprout, and I teach Herbology at Hogwarts.<br>" +
                        "<br>" +
                        "In my class, we will explore the wonders of the magical plant world. We will learn how to cultivate, care for, and <br> use the various herbs and plants that grow in our gardens. Herbology is a subject that requires patience, <br> diligence, and a keen eye for detail. But it's also a subject that can bring great joy and satisfaction.<br>" +
                        "<br>" +
                        "In my class, you will learn how to identify and cultivate various magical plants, including those <br> that are dangerous and those that are beneficial. We will also explore the magical properties <br> of these plants and how they can be used in potions and other magical applications.<br>" +
                        "<br>" +
                        "But let me warn you, my young gardeners. Herbology is not just about planting pretty flowers. It's about understanding the <br> intricate relationships between plants and their environment. It's about recognizing the subtle signs of disease and pests <br> and how to deal with them. It's about understanding the importance of soil and water quality and how to maintain them.<br>" +
                        "<br>" +
                        "In my class, we will work hard, and we will get our hands dirty. We will spend hours in the greenhouse, cultivating <br> and caring for our plants. We will also take field trips to the Forbidden Forest to gather rare and exotic specimens.<br>" +
                        "<br>" +
                        "But don't worry; I will be there to guide you every step of the way. I am a firm believer in the power of positive reinforcement <br> and encouragement. I will celebrate your successes and help you learn from your mistakes.<br>" +
                        "<br>" +
                        "So, if you're ready to get your hands dirty and learn the secrets of the magical plant world, then welcome to my class. <br> I promise you that you will leave here not just as a better gardener, but as a better person too.</div></html>";
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
