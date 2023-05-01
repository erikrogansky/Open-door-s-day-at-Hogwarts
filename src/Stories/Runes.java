package Stories;

import GUI.Stories;
import Game.Player;

public class Runes extends Story {
    @Override
    public void playStory(Player player){
        this.player = player;
        GUI = new Stories(this.player, "Welcome to the Archaic Library", "img/arlibrary.jpg");
        Thread storyThread = new Thread(new Runnable() {
            @Override
            public void run() {
                story = "<html><div style='text-align:center'>Welcome to the Archaic Library, where the secrets of the ancient world are waiting to be uncovered. <br> I am Professor Bathsheda Babbling, and I teach Ancient Runes here at Hogwarts.<br>" +
                        "<br>" +
                        "In my class, you will learn about the ancient language of the runic alphabet, which has been used <br> for centuries to communicate ideas and convey knowledge. We'll explore the history and culture <br> of the civilizations that used this language, from the Norse to the Egyptians to the ancient Greeks.<br>" +
                        "<br>" +
                        "But make no mistake, Ancient Runes is not an easy subject. It requires a sharp mind, a keen eye <br> for detail, and a deep understanding of the nuances of language. You must be <br> willing to put in the time and effort to master this ancient art.<br>" +
                        "<br>" +
                        "In my class, you'll spend countless hours pouring over dusty tomes, deciphering ancient texts, and <br> piecing together the secrets of the past. And let me tell ya, it's not for the faint of heart.<br>" +
                        "<br>" +
                        "But the rewards of studying Ancient Runes are immeasurable. You'll gain a deep understanding of <br> the cultures and civilizations of the past, and you'll learn to appreciate <br> the beauty and complexity of language in all its forms.<br>" +
                        "<br>" +
                        "And if you're willing to put in the work, I promise you that the secrets of the ancient world will <br> be yours to uncover. So, if you're ready to embark on a journey of discovery through <br> the pages of history, then welcome to my class. Together, we'll unlock the <br> secrets of the past and gain a new appreciation for the power of language.</div></html>";
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
