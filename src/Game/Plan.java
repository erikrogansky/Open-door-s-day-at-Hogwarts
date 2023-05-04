package Game;

import Stories.*;

import java.io.Serializable;

public class Plan implements Serializable {
    private Story welcome = new Welcome();
    private Story story1;
    private Story story2;
    private Story story3;
    private Story story4;
    private Story story5;
    private Story story6;
    private Story story7;
    private String[] array;
    private int currentMinigame = 0;
    public void createPlan(Story[] array, String[] array2){
        this.array = array2;
        this.story1 = array[0];
        this.story2 = array[1];
        this.story3 = array[2];
        this.story4 = array[3];
        this.story5 = array[4];
        this.story6 = array[5];
        this.story7 = array[6];
    }
    public Story getStory(int i){
        if (i==0)
            return welcome;
        if (i==1)
            return story1;
        if (i==2)
            return story2;
        if (i==3)
            return story3;
        if (i==4)
            return story4;
        if (i==5)
            return story5;
        if (i==6)
            return story6;
        else
            return story7;
    }
    public String[] getPlanArray(){
        return array;
    }
    public void incCurrent(){
        this.currentMinigame++;
    }
    public void setCurrent(int index){
        this.currentMinigame = index;
    }
    public int getCurrent(){
        return currentMinigame;
    }
}
