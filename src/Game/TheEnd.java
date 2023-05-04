package Game;

public class TheEnd {
    private Player player;
    Boolean done;
    public TheEnd(Player player) {
        this.player = player;

        this.done = true;
    }
    public Boolean ifDone() {
        new Waiter().wait(() -> done);
        return done;
    }
}
