package Game;

import GUI.TheEndGUI;

public class TheEnd {
    private Player player;
    private Boolean done;
    private boolean back_or_finish;
    public TheEnd(Player player) {
        this.player = player;
        TheEndGUI GUI = new TheEndGUI(player);
        GUI.ifDone();
        back_or_finish = GUI.ifBack();
        this.done = true;
    }
    public Boolean ifDone() {
        new Waiter().wait(() -> done);
        return done;
    }
    public Boolean ifBack() {
        return back_or_finish;
    }
}
