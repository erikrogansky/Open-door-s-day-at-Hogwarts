package Stories;

import Game.*;
import GUI.*;

import java.io.Serializable;

/**
 * This is an abstract class from which other classes in this package are derived.
 */
public abstract class Story implements Serializable {
    /**
     * The player of the game
     */
    protected Player player;
    /**
     * The boolean to indicate if the actions in the classes derived from this are done
     */
    protected Boolean done;
    /**
     * A variable to store the story
     */
    protected String story;
    /**
     * A string builder where the story will be built letter by letter.
     */
    protected String string_builder = "";
    /**
     * A variable where the {@link Stories} GUI class will be saved.
     */
    protected Stories GUI;
    /**
     * A variable to store the index of the character in the story
     */
    protected int i = 0;

    /**
     * An abstract method to play the story.
     * @param player the player
     * @throws InterruptedException is thrown if there is a problem in {@link Waiter} class
     */
    public abstract void playStory(Player player) throws InterruptedException;

    /**
     * This is a method that uses {@link Waiter} class to wait until everything in this class is done.
     * @throws InterruptedException is thrown if there is a problem in {@link Waiter} class
     * @return the boolean value of {@link #done}
     */
    public Boolean ifDone() throws InterruptedException {
        new Waiter().wait(() -> done);
        return done;
    }
    /**
     * This is a method to get the new instance of a class derived from {@link Story} it is called from.
     * Which class it is, must be found using RTTI.
     * @throws InstantiationException is thrown if the new instance cannot be created
     * @throws IllegalAccessException is thrown if the class does not have access to the details of the instance
     * @return the new instance
     */
    public Story reload() throws InstantiationException, IllegalAccessException {
        Class<? extends Story> cl = this.getClass();
        return cl.newInstance();
    }
}
