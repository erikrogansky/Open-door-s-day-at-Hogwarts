package Stories;

import Game.*;
import GUI.*;

import java.io.Serializable;

public abstract class Story implements Serializable {
    Player player;
    Boolean done;
    String story;
    String string_builder = "";
    Stories GUI;
    int i = 0;
    public void playStory(Player player){
        this.player = player;
    }
    public Boolean ifDone() {
        new Waiter().wait(() -> done);
        return done;
    }
    public Story reload() throws InstantiationException, IllegalAccessException {
        Class<? extends Story> cl = this.getClass();
        return cl.newInstance();
    }
}
