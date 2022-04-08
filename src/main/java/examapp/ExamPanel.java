package examapp;

import java.util.Scanner;

import static java.lang.System.out;

public class ExamPanel {

    private final Scanner READER = new Scanner(System.in);
    private final Menu MENU = new Menu();

    public void startProgram() {

        out.println("""

                ███████╗██╗░░██╗░█████╗░███╗░░░███╗  ██████╗░░█████╗░███╗░░██╗███████╗██╗░░░░░  ███████╗░█████╗░
                ██╔════╝╚██╗██╔╝██╔══██╗████╗░████║  ██╔══██╗██╔══██╗████╗░██║██╔════╝██║░░░░░  ╚════██║██╔══██╗
                █████╗░░░╚███╔╝░███████║██╔████╔██║  ██████╔╝███████║██╔██╗██║█████╗░░██║░░░░░  ░░░░██╔╝███████║
                ██╔══╝░░░██╔██╗░██╔══██║██║╚██╔╝██║  ██╔═══╝░██╔══██║██║╚████║██╔══╝░░██║░░░░░  ░░░██╔╝░██╔══██║
                ███████╗██╔╝╚██╗██║░░██║██║░╚═╝░██║  ██║░░░░░██║░░██║██║░╚███║███████╗███████╗  ░░██╔╝░░██║░░██║
                ╚══════╝╚═╝░░╚═╝╚═╝░░╚═╝╚═╝░░░░░╚═╝  ╚═╝░░░░░╚═╝░░╚═╝╚═╝░░╚══╝╚══════╝╚══════╝  ░░╚═╝░░░╚═╝░░╚═╝""");

        Menu.showMenu();

        String choice = "";

        while(!choice.equals("x")) {
            choice = READER.nextLine();
            MENU.getChoise(choice);
//            if(!choice.equals("x")){
//                Menu.showMenu();
//            }
        }


    }
}
