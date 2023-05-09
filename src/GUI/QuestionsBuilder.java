package GUI;

import Game.Player;

public class QuestionsBuilder extends Builder implements BuilderInterface {
    protected String[] myQuestions;
    protected String[][] myOptions;

    public QuestionsBuilder addQuestionList(String myQuestions[]) {
        this.myQuestions = myQuestions;
        return this;
    }
    public QuestionsBuilder addOptionList(String myOptions[][]) {
        this.myOptions = myOptions;
        return this;
    }
    @Override
    public QuestionsBuilder setPlayer(Player player) {
        this.player = player;
        return this;
    }
    @Override
    public QuestionsBuilder setSuper(String spr) {
        this.super_title = spr;
        return this;
    }
    @Override
    public QuestionsBuilder setImagePath(String path) {
        this.image_path = path;
        return this;
    }
    public QuestionsGUI build() {
        return new QuestionsGUI(this);
    }
}