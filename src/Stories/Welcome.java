package Stories;

import GUI.StoryBuilder;
import Game.Player;

public class Welcome extends Story {
    @Override
    public void playStory(Player player){
        this.player = player;
        string_builder = "";
        i = 0;
        StoryBuilder storyBuilder = new StoryBuilder();
        storyBuilder.setPlayer(player);
        storyBuilder.setSuper("Welcome to Hogwarts");
        storyBuilder.setImagePath("img/welcome.jpg");
        GUI = storyBuilder.build();
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
