package GUI;

import Game.Player;

import java.io.Serializable;

/**
 * This is an abstract class which implements some basic variables which other Builders will be derived from.
 */
public abstract class Builder {
    /**
     * This is a current player
     */
    protected Player player;
    /**
     * This variable is used to store a title which will be displayed in the GUI
     */
    protected String super_title;
    /**
     * This variable is used to store the path for the background image
     */
    protected String image_path;
}