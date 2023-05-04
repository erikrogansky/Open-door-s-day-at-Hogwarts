package Stories;

import Game.*;
import GUI.*;

import java.io.Serializable;

public abstract class Story implements Serializable {
    Player player;
    Boolean done;
    String story;
    String builder = "";
    Stories GUI;
    public void playStory(Player player){
        this.player = player;
    }
    public Boolean ifDone() {
        new Waiter().wait(() -> done);
        return done;
    }
}
