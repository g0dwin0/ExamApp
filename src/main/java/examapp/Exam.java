package examapp;

import java.util.ArrayList;


public class Exam {
    private final String name;
    private final ArrayList<Question> questions;

    public Exam(String name, ArrayList<Question> questions) {
        this.name = name;
        this.questions = questions;
    }

    public String getName() {
        return name;
    }

    public Exam() {
        this("", null);
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

}
