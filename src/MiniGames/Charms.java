package MiniGames;

import GUI.CharmsGUI;
import GUI.Welcome;
import Game.Player;

public class Charms extends MiniGame {
    @Override
    public void startGame(Player player){
        this.player = player;
        CharmsGUI GUI = new CharmsGUI(this.player);
        GUI.ifDone();
        this.done = true;
    }

}
