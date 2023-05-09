package Game;

import GUI.TheEndGUI;

/**
 * This class handles the ending GUI.
 */
public class TheEnd {
    private Player player;
    private Boolean done;
    private boolean back_or_finish;

    /**
     * In this constructor, the {@link #player} is initialized, and the {@link TheEndGUI} is created.
     * @param player the player
     * @throws InterruptedException is thrown if there is a problem in {@link Waiter} class
     */
    public TheEnd(Player player) throws InterruptedException {
        this.player = player;
        TheEndGUI GUI = new TheEndGUI(player);
        GUI.ifDone();
        back_or_finish = GUI.ifBack();
        this.done = true;
    }
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
     * This is a method to get the boolean value of {@link #back_or_finish} to estimate which button was pressed in the {@link TheEndGUI}.
     * @return the boolean value of {@link #back_or_finish}
     */
    public Boolean ifBack() {
        return back_or_finish;
    }
}
