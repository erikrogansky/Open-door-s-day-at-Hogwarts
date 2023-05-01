package Stories;

import GUI.Stories;
import Game.Player;

public class DefenseAgainstTheDarkArts extends Story {
    @Override
    public void playStory(Player player){
        this.player = player;
        GUI = new Stories(this.player, "Welcome to the Dark Forest", "img/forest.jpeg");
        Thread storyThread = new Thread(new Runnable() {
            @Override
            public void run() {
                story = "<html><div style='text-align:center'>Welcome to the Dark Forest, young "+ player.getGender('s') +"! I am Professor Remus Lupin, <br> and I teach Defence Against the Dark Arts here at Hogwarts.<br>" +
                        "<br>" +
                        "The Dark Forest is not a place to be taken lightly. It's full of dangerous creatures and dark magic <br> that can harm even the most skilled wizards and witches. But fear not, for here in my class, we <br> will teach you how to defend yourself against these dark forces.<br>" +
                        "<br>" +
                        "Defence Against the Dark Arts is a vital subject, and it's one that we take very seriously here at Hogwarts. In my class, we <br> focus on honing your defensive skills and teaching you how to fight against the dark creatures that lurk in the shadows.<br>" +
                        "<br>" +
                        "But let me be clear. This is not a subject for the faint-hearted. You must be brave, focused, and ready to face your <br> fears head-on. We will be training in the Dark Forest, so you must be prepared for whatever challenges come your way.<br>" +
                        "<br>" +
                        "In my class, we will learn spells that can protect us from dark creatures such as werewolves, vampires, <br> and other dark beings. We will also learn how to recognize and defend against curses and dark magic. <br> But most importantly, we will learn how to stay calm and focused in high-pressure situations.<br>" +
                        "<br>" +
                        "Defence Against the Dark Arts is not just about casting spells. It's about developing your mind and your <br> instincts. It's about learning to trust yourself and your abilities. It's about facing your fears and overcoming them.<br>" +
                        "<br>" +
                        "So, if you're ready to take on the challenges that lie ahead and to learn how to defend yourself against the dark forces, <br> then welcome to my class. I promise you that you will leave here not just as a better "+ player.getGender('s') +", but as a better person too.</div></html>";
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
