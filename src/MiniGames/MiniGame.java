package MiniGames;

import Game.Player;
import Game.Waiter;

import java.io.Serializable;

public class MiniGame implements Serializable {
    Player player;
    Boolean done;
    public void startGame(Player player){
        this.player = player;
    }
    public Boolean ifDone() {
        new Waiter().wait(() -> done);
        return done;
    }
}
