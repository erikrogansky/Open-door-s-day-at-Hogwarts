package Game;

import Stories.*;

import java.io.Serializable;

/**
 * This class is used to work with a plan of a trip around Hogwarts.
 */
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

    /**
     * This method is used to assign each story to the right place in the {@link Plan} object.
     * @param array is created in {@link GUI.CreatePlan} and stores all 7 stories which a player chose
     * @param array2 is created in {@link GUI.CreatePlan} and stores the names of the stories
     */
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

    /**
     * This method is used to get the story at the given index.
     * @param index is used as an index of a story in the {@link Plan} object
     * @return the wanted story
     */
    public Story getStory(int index){
        if (index==0)
            return welcome;
        if (index==1)
            return story1;
        if (index==2)
            return story2;
        if (index==3)
            return story3;
        if (index==4)
            return story4;
        if (index==5)
            return story5;
        if (index==6)
            return story6;
        else
            return story7;
    }

    /**
     * This method is used to get the {@link #array} with the String names of the chosen stories.
     * @return the array
     */
    public String[] getPlanArray(){
        return array;
    }

    /**
     * This method increments the {@link #currentMinigame}.
     */
    public void incCurrent(){
        this.currentMinigame++;
    }
    /**
     * This method decrements the {@link #currentMinigame}.
     */
    public void decCurrent(){
        this.currentMinigame--;
    }
    /**
     * This method sets the {@link #currentMinigame} to the given number.
     * @param index is used as an index of a story
     */
    public void setCurrent(int index){
        this.currentMinigame = index;
    }
    /**
     * This method is to get the {@link #currentMinigame}.
     * @return the {@link #currentMinigame}
     */
    public int getCurrent(){
        return currentMinigame;
    }

    /**
     * This method is used to reload the story at the given index.
     * @param i is used as an index of a story
     * @param story is a story that is supposed to be placed at the given index
     */
    public void reload(int i, Story story){
        if (i==0)
            welcome = new Welcome();
        if (i==1)
            story1 = story;
        if (i==2)
            story2 = story;
        if (i==3)
            story3 = story;
        if (i==4)
            story4 = story;
        if (i==5)
            story5 = story;
        if (i==6)
            story6 = story;
        else
            story7 = story;
    }
    public void reload(int i){
        if (i==0)
            welcome = new Welcome();
    }

}
