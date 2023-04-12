package Game;

import Stories.*;

import java.io.Serializable;

public class Plan implements Serializable {
    MiniGame minigame1;
    MiniGame minigame2;
    MiniGame minigame3;
    MiniGame minigame4;
    MiniGame minigame5;
    MiniGame minigame6;
    MiniGame minigame7;
    String[] array;
    int currentMinigame = 0;
    public void createPlan(MiniGame[] array, String[] array2){
        this.array = array2;
        this.minigame1 = array[0];
        this.minigame2 = array[1];
        this.minigame3 = array[2];
        this.minigame4 = array[3];
        this.minigame5 = array[4];
        this.minigame6 = array[5];
        this.minigame7 = array[6];
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
