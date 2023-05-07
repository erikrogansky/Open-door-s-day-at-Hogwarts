package Stories;

import GUI.Stories;
import Game.Player;

public class Creatures extends Story {
    @Override
    public void playStory(Player player){
        this.player = player;
        builder = "";
        GUI = new Stories(this.player, "Welcome to the Magical Creature Forest", "img/magicalforest.jpg");
        Thread storyThread = new Thread(new Runnable() {
            @Override
            public void run() {
                story = "<html><div style='text-align:center'>Welcome to the Magical Creatures Forest, yer all! I'm Rubeus Hagrid, <br> Keeper of Keys and Grounds here at Hogwarts, and I teach the Care of Magical Creatures.<br>" +
                        "<br>" +
                        "In my class, you will learn about the wondrous and mysterious creatures that inhabit our world. From unicorns <br> to dragons, from centaurs to hippogriffs, we'll be exploring creatures that you never knew existed.<br>" +
                        "<br>" +
                        "But let me make one thing clear, these creatures are not pets. They are living beings with <br> unique personalities, habits, and needs. And you must learn to treat them with respect and care.<br>" +
                        "<br>" +
                        "In my class, we'll be spending a lot of time in the forest, where you'll learn to care for these creatures in their <br> natural habitat. You'll learn how to handle them safely, how to feed them, and how to understand their behaviors.<br>" +
                        "<br>" +
                        "And let me tell ya, some of these creatures can be dangerous if not handled <br> properly. That's why we'll be following strict safety protocols at all times.<br>" +
                        "<br>" +
                        "But don't worry, I'll be there with ya every step of the way. I have a deep love and respect for these creatures, <br> and I want to share that with ya all. And I promise you that if you show them the same love and respect <br> that I do, you'll be rewarded with a lifelong appreciation for the natural world.<br>" +
                        "<br>" +
                        "So, if you're ready to embark on an adventure through the Magical Creatures Forest, then welcome <br> to my class. I promise you that you'll leave here not just with a better understanding of magical creatures, <br> but with a deeper appreciation for the beauty and wonder of the natural world.</div></html>";
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
