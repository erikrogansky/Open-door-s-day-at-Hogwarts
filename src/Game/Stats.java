package Game;

import GUI.StatsBuilder;
import GUI.StatsGUI;

import java.util.ArrayList;
import java.util.List;

/**
 * This class handles the stats of the game.
 */
public class Stats {
    private Player player;
    List<String[]> information = new ArrayList<>();
    Boolean done;
    public Stats(Player player) {
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
    public Boolean ifDone() {
        new Waiter().wait(() -> done);
        return done;
    }
}
