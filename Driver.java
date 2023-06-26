import java.util.Scanner;

/**
 * @author Adam McDonald
 * @version 0.1
 * <p> The Driver class runs everything and checks if the user wishes to continue or exit after each cycle.
 *
 * </p>
 */


public class Driver{
    public static void main(String[] args) {
        Scanner scanObj = new Scanner(System.in);
        keyAndMessageObj KAMO = new keyAndMessageObj();
        boolean yesNo = true;
        do {KAMO.welcome(scanObj);
            System.out.println("Would you like to continue or exit: (Y/N): ");
            String contChoice = scanObj.nextLine();
            switch (contChoice){
                case "Y":
                    yesNo = true;
                    break;
                case "N":
                    yesNo = false;
                    break;
                default:
                    System.err.println("No an option, please enter either Y or N.");
                    break;
            }

        }while(yesNo);
        System.out.println("Exiting System, have a good day");
        /**
         * I do not know why I put the following line here.
         */
        String contChoice = scanObj.nextLine();
        System.exit(1);



    }
}
