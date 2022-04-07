import java.util.ArrayList;

public class Resultaat {
    private Exam exam;
    private Integer aantalJuist;
    public boolean gehaald = isGehaald();

    public Resultaat(Exam exam, Integer aantalJuist) {
        this.exam = exam;
        this.aantalJuist = aantalJuist;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public Integer getAantalJuist() {
        return aantalJuist;
    }

    public void setAantalJuist(Integer aantalJuist) {
        this.aantalJuist = aantalJuist;
    }

    public boolean isGehaald() {
        boolean resultaat = false;
        ArrayList<Vraag> vragen = this.exam.getVragen();
        double cijfer = this.aantalJuist / vragen.size() * 10.0;
        if ( 5.5 >= cijfer) {
            resultaat = true;
        } else {
            resultaat = false;
        }
        return resultaat;
    }



}
