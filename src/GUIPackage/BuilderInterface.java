package GUIPackage;

import GamePackage.Player;

import java.io.Serializable;

/**
 * This interface is used to define the methods every builder will have
 */
public interface BuilderInterface extends Serializable {
    /**
     * A method to set the player
     * @param player the player
     * @return the builder
     */
    BuilderInterface setPlayer(Player player);

    /**
     * A method to set the super title
     * @param spr the super title
     * @return the builder
     */
    BuilderInterface setSuper(String spr);

    /**
     * A method to set the background image path
     * @param path the path
     * @return the builder
     */
    BuilderInterface setImagePath(String path);
}
