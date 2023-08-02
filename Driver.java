import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


/**
 * @author Adam McDonald
 * @version 0.2
 * <p>Driver class acts as an introductory UI.</p>
 */

public class Driver {
    public static void main(String[] args) throws IOException {
        Scanner scanObj = new Scanner(System.in);
        String restart = "C";
        while (restart.equals("C")) {
            System.out.println("Welcome to the tool, choose function\n1. Encrypt\n2. Decrypt");
            String userChoice = scanObj.nextLine();

            switch (userChoice) {
                case "1" -> {
                    Encryption en = new Encryption(scanObj);
                }
                case "2" -> {
                    Decrypt de = new Decrypt(scanObj);
                }
                default -> System.out.println("That's not an option");
            }
            System.out.println("Would you like to continue to main menu or exit from the program? (E for exit, C for continue): ");
            restart = scanObj.nextLine();
            while(!restart.equals("E") && !restart.equals("C")){
                System.out.println("Sorry, "+restart+", is not an option. Please choose C for continue or E for exit.");
                restart = scanObj.nextLine();
            }


        }
        System.out.println("Thank you for using the Caesar Cipher Solver, have a nice day!");
    }
}
