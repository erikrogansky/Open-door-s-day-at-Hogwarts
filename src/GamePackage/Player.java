package GamePackage;

import java.io.Serializable;

/**
 * This class stores the player's features, their plan, interests, points and rewards.
 */
public class Player implements Serializable {
    /**
     * A variable to store the player's login
     */
    private String login;
    /**
     * A variable to store the player's name
     */
    private String name;
    /**
     * A variable to store the player's gender
     */
    private String gender;
    /**
     * A variable to store the player's house
     */
    private String preferred_house;
    /**
     * A variable to store the player's interests
     */
    private String[] interests;
    /**
     * A variable to store the player's plan
     */
    private Plan personal_plan;
    /**
     * A variable to store the player's points
     */
    private int points = 0;
    /**
     * A variable to store the player's rewards
     */
    private String[] rewards = null;

    /**
     * This method assigns the player's {@link #login}.
     * @param login a string representing the player's login.
     */
    public void setLogin(String login){
        this.login = login;
    }
    /**
     * This method assigns the player's {@link #name}.
     * @param name a string representing the player's name.
     */
    public void setName(String name){
        this.name = name;
    }
    /**
     * This method assigns the player's {@link #gender}, but it transforms it into a more in-game format.
     * @param gender a string representing the player's gender.
     */
    public void setGender(String gender){
        if (gender.equals("male"))
            this.gender = "Wizard";
        if (gender.equals("female"))
            this.gender = "Witch";
        if (gender.equals("other"))
            this.gender = "Magician";
    }
    /**
     * This method assigns the player's {@link #preferred_house}.
     * @param house string representing the player's house.
     */
    public void setPreferred_house(String house){
        this.preferred_house = house;
    }

    /**
     * This method returns the player's {@link #personal_plan}, but it creates a new {@link Plan} object if it's null.
     * @return it returns the player's plan, or the newly created one.
     */
    public Plan changePlan(){
        if (this.personal_plan == null)
            this.personal_plan = new Plan();
        return personal_plan;
    }
    /**
     * This method assigns the player's {@link #personal_plan}.
     * @param plan is a {@link Plan} object.
     */
    public void changePlan(Plan plan){
        this.personal_plan = plan;
    }

    /**
     * It is sometimes necessary to get the player's login from the player, for example when the player wants to change some information,
     * a new player is created in the {@link GUIPackage.PlayerSetup} class and the login needs to be gotten from somewhere to assign it, and this is the place.
     * @return the login
     */
    public String getLogin(){
        return login;
    }

    /**
     * This method is used to get {@link #name}.
     * @return a string representing the player's name.
     */
    public String getName(){
        return name;
    }

    /**
     * This method assigns the player's {@link #interests}.
     * @param array array of interests
     */
    public void addInterests(String[] array){
        interests = array;
    }

    /**
     * This method increments the player's {@link #points}.
     */
    public void addPoints(){
        points++;
    }

    /**
     * This method increments the player's {@link #points} by the given amount.
     * @param add the amount of points to add
     */
    public void addPoints(int add){
        points += add;
    }

    /**
     * This method is to get the player's {@link #points}.
     * @return the player's points
     */
    public int getPoints(){ return points; }

    /**
     * This method adds rewards to the player's {@link #rewards} according to the amount of {@link #points}.
     */
    public void evaluateRewards(){
        if (rewards == null)
            rewards = new String[]{"", "", "", "", "", ""};
        if (this.points == 48){
            rewards[5] = "Firebolt";
        }
        if (this.points >= 40){
            rewards[4] = "A wand";
        }
        if (this.points >= 32){
            rewards[3] = "Felix Felicis";
        }
        if (this.points >= 24){
            rewards[2] = "An owl";
        }
        if (this.points >= 16){
            rewards[1] = "A goblet";
        }
        if (this.points >= 8){
            rewards[0] = "A house scarf";
        }
    }

    /**
     * This method is to get the player's {@link #rewards}.
     * @return the player's rewards array
     */
    public String[] getRewards(){ return rewards; }
    /**
     * This method is to get the player's {@link #preferred_house}.
     * @return the player's house
     */
    public String getHouse(){
        return preferred_house;
    }
    /**
     * This method is to get the player's {@link #interests}.
     * @return the player's interests array
     */
    public String[] getInterests(){
        return interests;
    }
    /**
     * This method is to get the player's {@link #rewards}.
     * @param c random object, which is not used, but is needed to differentiate between the {@link #getGender()} and {@link #getGender(Object)}.
     * @return the player's rewards array
     */
    public String getGender(Object c){
        if (gender.equals("Wizard"))
            return "wizard";
        else if (gender.equals("Witch"))
            return "witch";
        else
            return "magician";
    }
    /**
     * This method is to get the player's {@link #gender}.
     * @return the player's gender
     */
    public String getGender(){
        return gender;
    }
}
