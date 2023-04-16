package Stories;

import GUI.*;
import Game.Player;

public class Quidditch extends Story {
    @Override
    public void startGame(Player player){
        this.player = player;
        QuidditchGUI GUI = new QuidditchGUI(this.player);
        GUI.ifDone();
        if (GUI.getRead())
            this.player.addPoints();
        this.done = true;
    }
}
