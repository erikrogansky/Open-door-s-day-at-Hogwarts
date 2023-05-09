package GUI;

import Game.Player;

import java.io.Serializable;

public interface BuilderInterface extends Serializable {
    BuilderInterface setPlayer(Player player);
    BuilderInterface setSuper(String spr);
    BuilderInterface setImagePath(String path);
}
