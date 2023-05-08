package Game;

import GUI.QuestionsGUI;
import GUI.StatsGUI;

import java.util.ArrayList;
import java.util.List;

public class Stats {
    private Player player;
    List<String[]> information = new ArrayList<>();
    Boolean done;
    public Stats(Player player) {
        this.player = player;
        this.player.evaluateRewards();
        information.add(new String[]{player.getName()});
        information.add(new String[]{player.getGender()});
        information.add(new String[]{player.getHouse()});
        information.add(player.getInterests());
        information.add(new String[]{String.valueOf(player.getPoints())});
        information.add(player.getRewards());
        StatsGUI GUI = new StatsGUI(player, information);
        GUI.ifDone();
        this.done = true;
    }
    public Boolean ifDone() {
        new Waiter().wait(() -> done);
        return done;
    }
}
