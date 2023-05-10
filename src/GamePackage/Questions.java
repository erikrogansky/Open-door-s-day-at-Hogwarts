package GamePackage;

import GUIPackage.QuestionsBuilder;
import GUIPackage.QuestionsGUI;

/**
 * This class handles the quiz after the stories are finished.
 */

public class Questions {
    /**
     * A variable to store the player
     */
    private Player player;
    /**
     * A variable to store the Boolean value that represents if all the actions in this class are done
     */
    private Boolean done;
    /**
     * A variable to store all the story names
     */
    private final String[] stories = {"Quidditch stadium - Rolanda Hooch","Transfiguration Classroom - Minerva McGonagall","Charms Classroom - Filius Flitwick","Hogwarts' Greenhouses - Pomona Sprout","Potions Classroom - Severus Snape","The Dark Forest - Remus Lupin","The Divination Classroom - Sybill Trelawney","Muggle Storage - Alecto Carrow","The Magical Creatures Forest - Rubeus Hagrid","The History Classroom - Cuthbert Binns", "Archaic Library - Bathsheda Babbling", "The Ghostly Hallways - Nearly Headless Nick", "The Alchemy Classroom - Albus Dumbledore", "The Library - Eleazar Fig"};
    /**
     * A variable to store all the questions
     */
    private final String[] allQuestions = {"What is the name of the golden snitch's flight pattern?", "What spell is used to mend broken objects?", "Which charm generates light source?", "Name essential ingredient in the Draught of Living Death.", "What potion is used to shape-shift?", "What type of creature resides in the Forbidden Forest?", "Name a method of interpreting the patterns of tea leaves.", "How is a wizard born to non-magical parents called?", "Which creature has a fatal attraction to shiny objects?", "Who was the first wizard to be Minister of Magic?", "Name the Wizarding World's ancient runic alphabet.", "How is teleporting from one place to another called?", "What is the primary ingredient in the Philosopher's Stone?", "How is the study of magical properties of objects called?"};
    /**
     * A variable to store all the possible answers
     */
    private final String[][] allOptions = {{"Zigzag", "Figure Eight", "W-Shaped"}, {"Protego", "Avifors", "Reparo"}, {"Nox", "Lumos", "Accio"}, {"Flobberworm", "Wormwood", "Valerian Root"}, {"Amortentia", "Polyjuice", "Felix Felicis"}, {"Centaurs", "Merpeople", "Giants"}, {"Palmistry", "Tasseography", "Astrology"}, {"Squib", "Muggle-born", "Half-blood"}, {"Phoenix", "Hippogriff", "Niffler"}, {"Ulick Gamp", "Nobby Leach", "Heloise Flume"}, {"Elder Futhark", "Ogham", "Hieroglyphics"}, {"Disapparition", "Apparition", "Portkey"}, {"Unicorn Horn", "Elixir of Life", "Phoenix Blood"}, {"Charms", "Transfiguration", "Enchantment"}};
    /**
     * A variable to store the correct answers
     */
    private final String[] allCorrectAnswers = {"Figure Eight", "Reparo", "Lumos", "Wormwood", "Polyjuice", "Centaurs", "Tasseography", "Muggle-born", "Niffler", "Ulick Gamp", "Elder Futhark", "Apparition", "Elixir of Life", "Enchantment"};
    /**
     * A variable to store the players questions according to the plan
     */
    private String[] myQuestions = new String[8];
    /**
     * A variable to store the corresponding options
     */
    private String[][] myOptions = new String[8][3];
    /**
     * A variable to store the corresponding correct answers
     */
    private String[] myCorrectAnswers = new String[8];

    /**
     * When this class is created, the right questions for the player, according to their plan are chosen and added to
     * the {@link #myQuestions}. The corresponding list of possible answers and a correct answer are added to
     * the {@link #myOptions} and {@link #myCorrectAnswers} Then, it then creates {@link QuestionsGUI} class which
     * shows the quiz for the player to play. It uses a Builder design pattern in {@link QuestionsBuilder} class,
     * which builds the GUI with the questions. Then after the player confirms their choices in the {@link QuestionsGUI} class,
     * it evaluates each answer and adds 5 points for each correct answer by calling {@link Player#addPoints(int)} method.
     * @param player the player
     * @throws InterruptedException is thrown if there is a problem in {@link Waiter} class
     */
    public Questions(Player player) throws InterruptedException {
        this.player = player;
        String[] plan = this.player.changePlan().getPlanArray();
        for (int i = 0; i < myQuestions.length; i++){
            if (i < 7){
                int index = 0;
                for (int j = 0; j < stories.length; j++){
                    if (stories[j].equals(plan[i])){
                        index = j;
                        break;
                    }
                }
                myQuestions[i] = allQuestions[index];
                myOptions[i] = allOptions[index];
                myCorrectAnswers[i] = allCorrectAnswers[index];
            } else {
                myQuestions[7] = "Who is the headmaster of Hogwarts?";
                myOptions[7] = new String[]{"Snape", "Dumbledore", "McGonagall"};
                myCorrectAnswers[7] = "Dumbledore";
            }
        }
        QuestionsGUI GUI = new QuestionsBuilder()
        .setPlayer(player)
        .setSuper("Question time")
        .setImagePath("img/welcome.jpg")
        .addQuestionList(myQuestions)
        .addOptionList(myOptions)
        .build();
        GUI.ifDone();
        String[] myAnswers = GUI.getAnswers();
        for (int i = 0; i < myAnswers.length; i++){
            if (myAnswers[i].equals(myCorrectAnswers[i])){
                this.player.addPoints(5);
            }
        }
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
