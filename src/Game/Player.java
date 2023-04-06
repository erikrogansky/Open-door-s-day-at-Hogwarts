package Game;

import GUI.*;
import MiniGames.Charms;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Player implements Serializable {
    String login;
    String name;
    String gender;
    String preferred_house;
    String[] interests;
    Plan personal_plan;
    int points = 0;
    String[] rewards;

    public void setName(String name){
        this.name = name;
    }
    public void setGender(String gender){
        if (gender.equals("male"))
            this.gender = "Wizard";
        if (gender.equals("female"))
            this.gender = "Witch";
        if (gender.equals("other"))
            this.gender = "Non-specified magician";
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
}
