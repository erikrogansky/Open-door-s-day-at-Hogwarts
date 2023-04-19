package Stories;

import GUI.DefenseAgainstTheDarkArtsGUI;
import Game.Player;

public class DefenseAgainstTheDarkArts extends Story {
    @Override
    public void startGame(Player player){
        this.player = player;
        DefenseAgainstTheDarkArtsGUI GUI = new DefenseAgainstTheDarkArtsGUI(this.player);
        GUI.ifDone();
        if (GUI.getRead())
            this.player.addPoints();
        this.done = true;
    }
}
