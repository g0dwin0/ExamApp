package examapp;

import java.util.ArrayList;


public class Exam {
    private String name;
    private Integer amountOfCorrectAnswers = 0;
    private ArrayList<Question> questions;
    private ArrayList<Result> results;

    public Exam(String name, ArrayList<Question> questions) {
        this.name = name;
        this.questions = questions;
    }

    public Double finalGrade(double punten) {
        double eindCijfer = punten / 15.0 * 10.0;
        return eindCijfer;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmountOfCorrectAnswers() {
        return amountOfCorrectAnswers;
    }

    public void setAmountOfCorrectAnswers(Integer amountOfCorrectAnswers) {
        this.amountOfCorrectAnswers = amountOfCorrectAnswers;
    }

    public Exam() {
        this("", null);
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public ArrayList<Result> getResults() {
        return results;
    }

    public void setResults(ArrayList<Result> results) {
        this.results = results;
    }

}
