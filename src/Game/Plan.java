package Game;

import Stories.*;

import java.io.Serializable;

public class Plan implements Serializable {
    Story story1;
    Story story2;
    Story story3;
    Story story4;
    Story story5;
    Story story6;
    Story story7;
    String[] array;
    int currentMinigame = 0;
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

    public String[] getPlanArray(){
        return array;
    }

    public void setCurrent(int current){
        this.currentMinigame = current;
    }

    public int getCurrent(){
        return currentMinigame;
    }
}
