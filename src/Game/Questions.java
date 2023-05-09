package Game;

import GUI.Builder;
import GUI.StoryBuilder;
import GUI.QuestionsBuilder;
import GUI.QuestionsGUI;

public class Questions {
    private Player player;
    Boolean done;
    private final String[] stories = {"Quidditch stadium - Rolanda Hooch","Transfiguration Classroom - Minerva McGonagall","Charms Classroom - Filius Flitwick","Hogwarts' Greenhouses - Pomona Sprout","Potions Classroom - Severus Snape","The Dark Forest - Remus Lupin","The Divination Classroom - Sybill Trelawney","Muggle Storage - Alecto Carrow","The Magical Creatures Forest - Rubeus Hagrid","The History Classroom - Cuthbert Binns", "Archaic Library - Bathsheda Babbling", "The Ghostly Hallways - Nearly Headless Nick", "The Alchemy Classroom - Albus Dumbledore", "The Library - Eleazar Fig"};
    private final String[] allQuestions = {"What is the name of the golden snitch's flight pattern?", "What is the most complex form of human Transfiguration?", "Which charm is used to mend broken objects?", "What is the most important ingredient in the Draught of Living Death?", "What potion is also known as the Draught of the Living Dead?", "What type of creature resides in the Forbidden Forest?", "What is the name of the divination method where the seer interprets the patterns of tea leaves?", "What is the name for a wizard who is born to non-magical parents?", "Which creature has a fatal attraction to shiny objects?", "What was the name of the first wizarding war against Voldemort?", "What is the name of the ancient runic alphabet used in the Wizarding World?", "What is the name for a wizard's ability to teleport themselves from one place to another?", "What is the ultimate goal of alchemy?", "What is the name for the study of the magical properties of objects?"};
    private final String[][] allOptions = {{"Zigzag", "Figure Eight", "W-Shaped"}, {"Vanishment", "Apparition", "Human Transfiguration"}, {"Reparo", "Wingardium Leviosa", "Accio"}, {"Flobberworm Mucus", "Wormwood", "Valerian Root"}, {"Amortentia", "Polyjuice Potion", "Draught of Living Death"}, {"Centaurs", "Merpeople", "Giants"}, {"Palmistry", "Tasseography", "Astrology"}, {"Squib", "Muggle-born", "Half-blood"}, {"Phoenix", "Hippogriff", "Niffler"}, {"The First Wizarding War", "The Battle of Hogwarts", "The War of the Roses"}, {"Elder Futhark", "Ogham", "Hieroglyphics"}, {"Disapparition", "Apparition", "Portkey"}, {"To transmute base metals into gold", "To create the philosopher's stone", "To achieve eternal life"}, {"Charms", "Transfiguration", "Enchantment"}};
    private final String[] allCorrectAnswers = {"Figure Eight", "Human Transfiguration", "Reparo", "Wormwood", "Draught of Living Death", "Centaurs", "Tasseography", "Muggle-born", "Niffler", "The First Wizarding War", "Elder Futhark", "Apparition", "To achieve eternal life", "Enchantment"};
    private String[] myQuestions = new String[8];
    private String[][] myOptions = new String[8][3];
    private String[] myCorrectAnswers = new String[8];
    public Questions(Player player) {
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
        QuestionsBuilder builder = new QuestionsBuilder();
        builder.setPlayer(player);
        builder.setSuper("Question time");
        builder.setImagePath("img/welcome.jpg");
        builder.addQuestionList(myQuestions);
        builder.addOptionList(myOptions);
        QuestionsGUI GUI = builder.build();
        GUI.ifDone();
        String[] myAnswers = GUI.getAnswers();
        for (int i = 0; i < myAnswers.length; i++){
            if (myAnswers[i].equals(myCorrectAnswers[i])){
                this.player.addPoints(5);
            }
        }
        this.done = true;
    }
    public Boolean ifDone() {
        new Waiter().wait(() -> done);
        return done;
    }
}
