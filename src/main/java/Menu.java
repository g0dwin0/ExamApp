import java.util.Scanner;

public class Menu {

    private final Scanner READER = new Scanner(System.in);

    public static void showMenu() {

        System.out.println("\n" +
                "███████╗██╗░░██╗░█████╗░███╗░░░███╗  ██████╗░░█████╗░███╗░░██╗███████╗██╗░░░░░  ███████╗░█████╗░\n" +
                "██╔════╝╚██╗██╔╝██╔══██╗████╗░████║  ██╔══██╗██╔══██╗████╗░██║██╔════╝██║░░░░░  ╚════██║██╔══██╗\n" +
                "█████╗░░░╚███╔╝░███████║██╔████╔██║  ██████╔╝███████║██╔██╗██║█████╗░░██║░░░░░  ░░░░██╔╝███████║\n" +
                "██╔══╝░░░██╔██╗░██╔══██║██║╚██╔╝██║  ██╔═══╝░██╔══██║██║╚████║██╔══╝░░██║░░░░░  ░░░██╔╝░██╔══██║\n" +
                "███████╗██╔╝╚██╗██║░░██║██║░╚═╝░██║  ██║░░░░░██║░░██║██║░╚███║███████╗███████╗  ░░██╔╝░░██║░░██║\n" +
                "╚══════╝╚═╝░░╚═╝╚═╝░░╚═╝╚═╝░░░░░╚═╝  ╚═╝░░░░░╚═╝░░╚═╝╚═╝░░╚══╝╚══════╝╚══════╝  ░░╚═╝░░░╚═╝░░╚═╝");

        System.out.println("1. Option 1");
        System.out.println("2. Option 2");
        System.out.println("3. Option 3");
        System.out.println("4. Option 4");
        System.out.println("5. Option 5");
        System.out.println("6. Option 6");
        System.out.println("X. Close program");
    }

    public void getChoise(String choise) {
        switch (choise) {
            case "1":
                System.out.println("test1");
                break;
            case "2":
                System.out.println("test2");
                break;
            case "3":
                System.out.println("test3");
                break;
            case "4":
                break;
            case "5":
                break;
            case "6":
                break;
        }
    }
}