package Stories;

import GUI.TransfigurationGUI;
import Game.Player;

public class Charms extends Story {
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
