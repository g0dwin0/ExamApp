import java.util.Scanner;

public class ExamAdministration {

    private final Scanner READER = new Scanner(System.in);
    private final Menu MENU = new Menu();

    public void startProgram() {

        System.out.println("""

                ███████╗██╗░░██╗░█████╗░███╗░░░███╗  ██████╗░░█████╗░███╗░░██╗███████╗██╗░░░░░  ███████╗░█████╗░
                ██╔════╝╚██╗██╔╝██╔══██╗████╗░████║  ██╔══██╗██╔══██╗████╗░██║██╔════╝██║░░░░░  ╚════██║██╔══██╗
                █████╗░░░╚███╔╝░███████║██╔████╔██║  ██████╔╝███████║██╔██╗██║█████╗░░██║░░░░░  ░░░░██╔╝███████║
                ██╔══╝░░░██╔██╗░██╔══██║██║╚██╔╝██║  ██╔═══╝░██╔══██║██║╚████║██╔══╝░░██║░░░░░  ░░░██╔╝░██╔══██║
                ███████╗██╔╝╚██╗██║░░██║██║░╚═╝░██║  ██║░░░░░██║░░██║██║░╚███║███████╗███████╗  ░░██╔╝░░██║░░██║
                ╚══════╝╚═╝░░╚═╝╚═╝░░╚═╝╚═╝░░░░░╚═╝  ╚═╝░░░░░╚═╝░░╚═╝╚═╝░░╚══╝╚══════╝╚══════╝  ░░╚═╝░░░╚═╝░░╚═╝""");

        Menu.showMenu();

        String Choice = "";
        //System.out.println("Enter your menu choise");

        while(!Choice.equals("x")) {
            Choice = READER.nextLine();
            MENU.getChoise(Choice);
            if(!Choice.equals("x")){
                Menu.showMenu();
            }
        }


    }
}
