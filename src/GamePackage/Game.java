package GamePackage;

import GUIPackage.*;
import StoriesPackage.*;

import java.io.*;

/**
 * This program implements a simple game, where short stories are displayed and after that,
 * the player answers simple questions.
 * <br><br>
 * This class is the main class of the program, which is responsible for the creation of the game,
 * and setting up the game using {@link PlayerSetup} and {@link CreatePlan} classes. When all is set,
 * the game is executed by calling {@link #play()} method, where each {@link Story} is played. After them {@link Questions} are asked,
 * {@link Stats} are displayed, and the game is ended by displaying {@link TheEnd}.
 *
 * @author Erik Roganský
 * @version 1.0
 * @since 2023-05-09
 */


public class Game implements Serializable {
    /**
     * A variable to store the login info
     */
    private String login;
    /**
     * A variable to store the player
     */
    private Player player;

    /**
     * This constructor is used to load or create a new game. To decide which one it is, it uses {@param newGame} parameter.
     * It uses a try-catch and if-condition to test if the new game should be created or an old one can be loaded.
     * If a new game should be created {@exception NewGameException} is thrown to execute the code in the catch part which catches {@exception FileNotFoundException}, {@exception InvalidClassException} and {@exception NewGameException}.
     * Then a new game is set and automatically saved by calling {@link #save()}. After all that {@link #play()} method is executed.
     * @param login is there to assign the login {@link String}.
     * @param newGame is there to check if a new game should be created, or it can be loaded.
     * @throws IOException is thrown if the file cannot be loaded
     * @throws ClassNotFoundException is thrown if the file cannot be found
     * @throws InterruptedException is thrown if there is a problem in {@link Waiter} class
     */
    public Game(String login, Boolean newGame) throws IOException, ClassNotFoundException, InterruptedException {
        this.login = login;
        try{
            if (!newGame)
                load();
            else
                throw new NewGameException();
        } catch (FileNotFoundException | InvalidClassException | NewGameException e){
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
    /**
     * This constructor is simply used play the game with the {@link Player} object passed to it.
     * @param player is there just to assign the player, and it's login.
     * @throws IOException is thrown if the file cannot be loaded
     * @throws ClassNotFoundException is thrown if the file cannot be found
     * @throws InterruptedException is thrown if there is a problem in {@link Waiter} class
     */
    public Game(Player player) throws IOException, ClassNotFoundException, InterruptedException {
        this.login = player.getLogin();
        this.player = player;
        save();
        play();
    }
    /**
     * This method is used to manage the actual "playing" the game. It uses autosave principle as it calls {@link #save()} method each time when the current step is finished.
     * If the {@link Plan#getCurrent()} is less than 8, it calls {@link Story#playStory(Player)} method which executes the {@link Story} at that index.
     * If the {@link Plan#getCurrent()} is equal to 8, it creates {@link Questions} class which creates the quiz.
     * If the {@link Plan#getCurrent()} is equal to 9, it creates {@link Stats} class which displays the statistics.
     * If the {@link Plan#getCurrent()} is equal to 10, it creates {@link TheEnd} class which displays 'The End' title.
     * @throws IOException is thrown if the file cannot be saved
     * @throws InterruptedException is thrown if there is a problem in {@link Waiter} class
     */
    public void play() throws IOException, InterruptedException {
        while (this.player.changePlan().getCurrent() < 11){
            if (this.player.changePlan().getCurrent() < 8) {
                this.player.changePlan().getStory(this.player.changePlan().getCurrent()).playStory(this.player);
                this.player.changePlan().getStory(this.player.changePlan().getCurrent()).ifDone();
                this.player.changePlan().incCurrent();
                save();
            } else if (this.player.changePlan().getCurrent() == 8) {
                Questions quiz = new Questions(this.player);
                quiz.ifDone();
                this.player.changePlan().incCurrent();
                save();
            } else if (this.player.changePlan().getCurrent() == 9) {
                Stats stats = new Stats(this.player);
                stats.ifDone();
                this.player.changePlan().incCurrent();
                save();
            } else if (this.player.changePlan().getCurrent() == 10) {
                TheEnd end = new TheEnd(this.player);
                end.ifDone();
                if (end.ifBack()) {
                    this.player.changePlan().decCurrent();
                    save();
                }
                else{
                    save();
                    System.exit(0);
                }
            }
        }
    }

    /**
     * This method from {@link Serializable} interface is used to save the game.
     * @throws IOException is thrown if the file cannot be saved
     */
    public void save() throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("logins/" + login + ".out"));
        out.writeObject(this);
        out.close();
    }

    /**
     * This method from {@link Serializable} interface is used to load the game.
     * @throws ClassNotFoundException is thrown if the file cannot be found
     * @throws IOException is thrown if the file cannot be loaded
     */
    public void load() throws ClassNotFoundException, IOException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("logins/" + login + ".out"));
        Game loadedGame = (Game) in.readObject();
        in.close();

        player = loadedGame.player;
        login = loadedGame.login;
    }

    /**
     * This static method is used to execute the whole program.
     * First a {@link StartupGUI} object is created and then the new game is created, with the parameters from the {@link StartupGUI} object.
     * @param args does nothing
     * @throws IOException is thrown if the file cannot be loaded
     * @throws ClassNotFoundException is thrown if the file cannot be found
     * @throws InterruptedException is thrown if there is a problem in {@link Waiter} class
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        StartupGUI start = new StartupGUI();
        new Game(start.getLogin(), start.getBool());
    }
}
