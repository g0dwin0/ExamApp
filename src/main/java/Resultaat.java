public class Resultaat {
    private Student student;
    private Exam exam;
    private Integer aantalJuist;
    private boolean gehaald;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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
        return gehaald;
    }

    public void setGehaald(boolean gehaald) {
        this.gehaald = gehaald;
    }


}
