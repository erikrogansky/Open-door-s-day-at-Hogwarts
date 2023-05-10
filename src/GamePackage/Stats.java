package GamePackage;

import GUIPackage.StatsBuilder;
import GUIPackage.StatsGUI;

/**
 * This class handles the stats of the game.
 */
public class Stats {
    /**
     * A variable to store the player
     */
    private Player player;
    /**
     * A variable to store the Boolean value that represents if all the actions in this class are done
     */
    private Boolean done;

    /**
     * In this constructor, the {@link #player} is initialized, and the rewards are evaluated by calling {@link Player#evaluateRewards()} and added to the {@link #player}.
     * Then a new {@link StatsBuilder} is created and is used to build the {@link StatsGUI}.
     * @param player the player
     * @throws InterruptedException is thrown if there is a problem in {@link Waiter} class
     */
    public Stats(Player player) throws InterruptedException {
        this.player = player;
        this.player.evaluateRewards();
        StatsGUI GUI = new StatsBuilder()
        .setSuper("Statistics")
        .setPlayer(player)
        .setName(player.getName())
        .setGender(player.getGender())
        .setHouse(player.getHouse())
        .setInterests(player.getInterests())
        .setPoints(player.getPoints())
        .setRewards(player.getRewards())
        .build();
        GUI.ifDone();
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
}
