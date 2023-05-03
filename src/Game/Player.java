package Game;

import java.io.Serializable;

public class Player implements Serializable {
    private String login;
    private String name;
    private String gender;
    private String preferred_house;
    private String[] interests;
    private Plan personal_plan;
    private int points = 0;
    private String[] rewards;

    public void setLogin(String login){
        this.login = login;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setGender(String gender){
        if (gender.equals("male"))
            this.gender = "Wizard";
        if (gender.equals("female"))
            this.gender = "Witch";
        if (gender.equals("other"))
            this.gender = "Magician";
    }
    public void setPreferred_house(String house){
        this.preferred_house = house;
    }
    public Plan changePlan(){
        if (this.personal_plan == null)
            this.personal_plan = new Plan();
        return personal_plan;
    }
    public void changePlan(Plan plan){
        this.personal_plan = plan;
    }
    public String getLogin(){
        return login;
    }
    public void addInterests(String[] array){
        interests = array;
    }
    public void addPoints(){
        points++;
    }
    public void addPoints(int add){
        points += add;
    }
    public int getPoints(){ return points; }
    public void addReward(String[] reward){
        rewards = reward;
    }
    public String[] getRewards(){ return rewards; }
    public String getHouse(){
        return preferred_house;
    }
    public String[] getInterests(){
        return interests;
    }
    public String getGender(char c){
        if (c == 's'){
            if (gender.equals("Wizard"))
                return "wizard";
            else if (gender.equals("Witch"))
                return "witch";
            else
                return "magician";
        }
        else
            return gender;
    }
}
