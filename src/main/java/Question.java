import java.util.ArrayList;

public class Question {
    private String question;
//    private String antwoorden; // TODO: Abstracte klasse prolly the best here
    private String answer;
    private ArrayList<String> choice;
    private int points;

    public Question(String question, String answer, int points) {
        this.question = question;
        this.answer = answer;
        this.points = points;
    }

    public Question(String question, ArrayList<String> choice, String answer, int points){
        this.question = question;
        this.choice = choice;
        this.answer = answer;
        this.points = points;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getPoints() {return points;}


    public ArrayList<String> getChoice() {return choice;}

    public static ArrayList<Question> openQuestion() {
        ArrayList<Question> openQuestion = new ArrayList<>();
        openQuestion.add(new Question("Wat is 1 + 1","2",10));
        openQuestion.add(new Question("Wat is 1 + 3","4",10));
        openQuestion.add(new Question("Wat is 1 + 4","5",10));
        openQuestion.add(new Question("Wat is 1 + 1","2",10));

        return openQuestion;
    }
    public static ArrayList<Question> MultipleChoiceQuestion(){
        ArrayList<Question> multipleChoiceQuestion = new ArrayList<>();
        multipleChoiceQuestion.add(new Question("Welk land heeft de grootste landopervlakte", questionOptions("Amerika","Australie","China","Rusland"),"D", 2));
        multipleChoiceQuestion.add(new Question("Welk land ", questionOptions("Amerika","Australie","China","Rusland"),"D", 2));
        multipleChoiceQuestion.add(new Question("Welk land  grootste landopervlakte", questionOptions("Amerika","Australie","China","Rusland"),"D", 2));
        multipleChoiceQuestion.add(new Question("Welk land  landopervlakte", questionOptions("Amerika","Australie","China","Rusland"),"D", 2));

        return multipleChoiceQuestion;
    }

    public static ArrayList<String> questionOptions(String A, String B, String C, String D){
        ArrayList<String> choice = new ArrayList<>();
        choice.add("[A] " + A);
        choice.add("[B] " + B);
        choice.add("[C] " + C);
        choice.add("[D] " + D);
        return choice;
    }

}
