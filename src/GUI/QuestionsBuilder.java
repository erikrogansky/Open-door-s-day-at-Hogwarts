package GUI;

public class QuestionsBuilder extends Builder {
    String[] myQuestions;
    String[][] myOptions;
    public QuestionsBuilder addQuestionList(String myQuestions[]) {
        this.myQuestions = myQuestions;
        return this;
    }

    public QuestionsBuilder addOptionList(String myOptions[][]) {
        this.myOptions = myOptions;
        return this;
    }
    public QuestionsGUI build() {
        return new QuestionsGUI(this);
    }
}