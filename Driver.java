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

public class Driver{
    public static void main(String[] args) throws IOException {
        Scanner scanObj = new Scanner(System.in);
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

    }
}
