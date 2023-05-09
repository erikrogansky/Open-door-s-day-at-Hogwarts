package GUI;

import Game.Player;

/**
 * A builder class that is used to build a {@link Stories} class
 */
public class StoryBuilder extends Builder implements BuilderInterface {
    /**
     * A method to set the player
     * @param player the player
     * @return the builder
     */
    @Override
    public StoryBuilder setPlayer(Player player) {
        this.player = player;
        return this;
    }
    /**
     * A method to set the super title
     * @param spr the super title
     * @return the builder
     */
    @Override
    public StoryBuilder setSuper(String spr) {
        this.super_title = spr;
        return this;
    }
    /**
     * A method to set the background image path
     * @param path the path
     * @return the builder
     */
    @Override
    public StoryBuilder setImagePath(String path) {
        this.image_path = path;
        return this;
    }
    /**
     * A method to build the {@link Stories}GUI.
     * @return the {@link Stories}GUI
     */
    public Stories build() {
        return new Stories(this);
    }
}