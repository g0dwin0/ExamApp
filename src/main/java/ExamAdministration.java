import java.util.Scanner;

public class ExamAdministration {

    private final Scanner READER = new Scanner(System.in);
    private final Menu MENU = new Menu();

    public void startProgram() {
        Menu.showMenu();

        String Choise = READER.nextLine();
        //System.out.println("Enter your menu choise");

        while(!Choise.equals("x")) {
            MENU.getChoise(Choise);
            Choise = READER.nextLine();
        }
    }
}
