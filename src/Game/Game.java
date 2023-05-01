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
            this.player.login = login;
            CreatePlan plan = new CreatePlan(player);
            this.player = plan.getPlayer();
            new Waiter().wait(() -> player.personal_plan.story1);
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
        if (this.player.personal_plan.getCurrent() == 0){
            new Welcome(this.player).ifDone();
            this.player.personal_plan.setCurrent(1);
            save();
        }
        if (this.player.personal_plan.getCurrent() == 1){
            this.player.personal_plan.story1.playStory(this.player);
            this.player.personal_plan.story1.ifDone();
            this.player.personal_plan.setCurrent(2);
            save();
        }
        if (this.player.personal_plan.getCurrent() == 2){
            this.player.personal_plan.story2.playStory(this.player);
            this.player.personal_plan.setCurrent(3);
            save();
        }
        if (this.player.personal_plan.getCurrent() == 3){
            this.player.personal_plan.story3.playStory(this.player);
            this.player.personal_plan.setCurrent(4);
            save();
        }
        if (this.player.personal_plan.getCurrent() == 4){
            this.player.personal_plan.story4.playStory(this.player);
            this.player.personal_plan.setCurrent(5);
            save();
        }
        if (this.player.personal_plan.getCurrent() == 5){
            this.player.personal_plan.story5.playStory(this.player);
            this.player.personal_plan.setCurrent(6);
            save();
        }
        if (this.player.personal_plan.getCurrent() == 6){
            this.player.personal_plan.story6.playStory(this.player);
            this.player.personal_plan.setCurrent(7);
            save();
        }
        if (this.player.personal_plan.getCurrent() == 7){
            this.player.personal_plan.story7.playStory(this.player);
            this.player.personal_plan.setCurrent(8);
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
        Game game = new Game(start.getLogin(), start.getBool());
    }
}
