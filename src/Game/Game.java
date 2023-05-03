package Game;

import GUI.*;

import java.io.*;

public class Game implements Serializable {
    String login;
    Player player;

    public Game(String login, Boolean newGame) throws IOException, ClassNotFoundException {
        this.login = login;
        try{
            if (!newGame)
                load();
            else
                throw new FileNotFoundException();
        } catch (FileNotFoundException | InvalidClassException e){
            PlayerSetup setup = new PlayerSetup();
            this.player = setup.getPlayer();
            this.player.setLogin(login);
            CreatePlan plan = new CreatePlan(player);
            this.player = plan.getPlayer();
            new Waiter().wait(() -> player.changePlan().getStory(1));
            save();
        }
        play();
    }

    public Game(Player player) throws IOException, ClassNotFoundException {
        this.login = player.getLogin();
        this.player = player;
        save();
        play();
    }

    public void play() throws IOException {
        if (this.player.changePlan().getCurrent() == 0){
            new Welcome(this.player).ifDone();
            this.player.changePlan().incCurrent();
            save();
        }
        while (this.player.changePlan().getCurrent() != 8){
            this.player.changePlan().getStory(this.player.changePlan().getCurrent()).playStory(this.player);
            this.player.changePlan().getStory(this.player.changePlan().getCurrent()).ifDone();
            this.player.changePlan().incCurrent();
            save();
        }
    }

    public void save() throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("logins/" + login + ".out"));
        out.writeObject(this);
        out.close();
    }

    public void load() throws ClassNotFoundException, IOException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("logins/" + login + ".out"));
        Game loadedGame = (Game) in.readObject();
        in.close();

        player = loadedGame.player;
        login = loadedGame.login;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Startup start = new Startup();
        new Game(start.getLogin(), start.getBool());
    }
}
