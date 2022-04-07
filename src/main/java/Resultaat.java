import java.util.ArrayList;

public class Resultaat {
    private Exam exam;
    private Integer aantalJuist;
    public boolean gehaald;

    public Resultaat(Exam exam, Integer aantalJuist, boolean gehaald) {
        this.exam = exam;
        this.aantalJuist = aantalJuist;
        this.gehaald = gehaald;
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



}
