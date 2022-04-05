import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringChecker {

    public boolean isFullName(String name) {
        String regx = "^[a-zA-Z\\s]+";
        Pattern pattern = Pattern.compile(regx,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(name);
        return matcher.find() && name.length() > 2 && name.contains(" ");
    }

    public boolean isStudentNumber(String studentNumber) {
        String regx = "[0-9]+";
        Pattern pattern = Pattern.compile(regx,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(studentNumber);
        return matcher.find() && studentNumber.length() > 4;
    }
}
