package Stories;

import GUI.*;
import Game.*;

public class Transfiguration extends Story {
    @Override
    public void startGame(Player player){
        this.player = player;
        TransfigurationGUI GUI = new TransfigurationGUI(this.player);
        GUI.ifDone();
        if (GUI.getRead())
            this.player.addPoints();
        this.done = true;
    }
}
