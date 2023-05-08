package GUI;

import Game.Player;

import java.io.Serializable;

public interface BuilderInterface extends Serializable {
    Builder setPlayer(Player player);
    Builder setSuper(String spr);;
    Builder setImagePath(String path);
    Stories build();
}
