package Game;

import GUI.StatsBuilder;
import GUI.StatsGUI;

/**
 * This class handles the stats of the game.
 */
public class Stats {
    private Player player;
    private Boolean done;

    /**
     * In this constructor, the {@link #player} is initialized, and the rewards are evaluated by calling {@link Player#evaluateRewards()} and added to the {@link #player}.
     * Then a new {@link StatsBuilder} is created and is used to build the {@link StatsGUI}.
     * @param player the player
     */
    public Stats(Player player) throws InterruptedException {
        this.player = player;
        this.player.evaluateRewards();
        StatsBuilder builder = new StatsBuilder()
        .setName(player.getName())
        .setGender(player.getGender())
        .setHouse(player.getHouse())
        .setInterests(player.getInterests())
        .setPoints(player.getPoints())
        .setRewards(player.getRewards());
        StatsGUI GUI = builder.build();
        GUI.ifDone();
        this.done = true;
    }
    /**
     * This is a method that uses {@link Waiter} class to wait until everything in this class is done.
     * @return the boolean value of {@link #done}
     */
    public Boolean ifDone() throws InterruptedException {
        new Waiter().wait(() -> done);
        return done;
    }
}
