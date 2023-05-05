package Game;

import GUI.QuestionsGUI;
import GUI.StatsGUI;

public class Stats {
    private Player player;
    String[][] information = new String[6][7];
    Boolean done;
    public Stats(Player player) {
        this.player = player;
        this.player.evaluateRewards();
        information[0][0] = player.getName();
        information[1][0] = player.getGender();
        information[2][0] = player.getHouse();
        information[3] = player.getInterests();
        information[4][0] = String.valueOf(player.getPoints());
        information[5] = player.getRewards();
        StatsGUI GUI = new StatsGUI(player, information);
        GUI.ifDone();
        this.done = true;
    }
    public Boolean ifDone() {
        new Waiter().wait(() -> done);
        return done;
    }
}
