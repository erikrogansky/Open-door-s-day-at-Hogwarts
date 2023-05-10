package GUIPackage;

import GamePackage.Player;

/**
 * A builder class that is used to build a {@link StoryGUI} class
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
     * A method to build the {@link StoryGUI}GUI.
     * @return the {@link StoryGUI}GUI
     */
    public StoryGUI build() {
        return new StoryGUI(this);
    }
}