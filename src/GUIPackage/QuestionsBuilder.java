package GUIPackage;

import GamePackage.Player;

/**
 * A builder class that is used to build a {@link QuestionsGUI} class
 */
public class QuestionsBuilder extends Builder implements BuilderInterface {
    /**
     * A variable to store the chosen questions
     */
    protected String[] myQuestions;
    /**
     * A variable to store the chosen options
     */
    protected String[][] myOptions;

    /**
     * A method to set the questions
     * @param myQuestions the questions
     * @return the builder
     */
    public QuestionsBuilder addQuestionList(String[] myQuestions) {
        this.myQuestions = myQuestions;
        return this;
    }
    /**
     * A method to set the options
     * @param myOptions the options
     * @return the builder
     */
    public QuestionsBuilder addOptionList(String[][] myOptions) {
        this.myOptions = myOptions;
        return this;
    }
    /**
     * A method to set the player
     * @param player the player
     * @return the builder
     */
    @Override
    public QuestionsBuilder setPlayer(Player player) {
        this.player = player;
        return this;
    }
    /**
     * A method to set the super title
     * @param spr the super title
     * @return the builder
     */
    @Override
    public QuestionsBuilder setSuper(String spr) {
        this.super_title = spr;
        return this;
    }
    /**
     * A method to set the background image path
     * @param path the path
     * @return the builder
     */
    @Override
    public QuestionsBuilder setImagePath(String path) {
        this.image_path = path;
        return this;
    }
    /**
     * A method to build the {@link QuestionsGUI}.
     * @return the {@link QuestionsGUI}
     */
    public QuestionsGUI build() {
        return new QuestionsGUI(this);
    }
}