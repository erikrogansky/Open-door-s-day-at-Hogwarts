package Stories;

import GUI.CharmsGUI;
import Game.Player;

public class Charms extends Story {
    @Override
    public void startGame(Player player){
        this.player = player;
        CharmsGUI GUI = new CharmsGUI(this.player);
        GUI.ifDone();
        if (GUI.getRead())
            this.player.addPoints();
        this.done = true;
    }

}
