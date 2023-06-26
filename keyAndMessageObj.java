import java.util.Scanner;

/**
 * @author Adam McDonald
 * @version 0.1
 * </p> This class stores the key and message in an object.
 */

public class keyAndMessageObj {
    /**
     * String message represents an alphabetical message which the user gives, either to be decrypted or encrypted.
     */
    public String message;

    /**
     * int key represents the key of the Cipher, in other words the number of letters in the alphabet that each letter in the message will be shifted.
     */
    public int key;

    /**
     * Default constructor for this class.
     */

    public keyAndMessageObj(){
        this.message = message;
        this.key = key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    /**
     * getKey() is never used.
     */

    public int getKey() {
        return key;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * getMessage() is never used.
     */

    public String getMessage() {
        return message;
    }

    /**
     * <p>public void welcome(Scanner scanObj) is essentially the UI driver. It asks the user which function they would like to use and then directs
     * the user to the proper questions for their choice.
     * </p>
     * @param scanObj This is a global Scanner object for this project, can be found in public class Driver
     */
    public void welcome(Scanner scanObj){
        System.out.println("Welcome to the Caesar Cipher Tool"+'\n'+"What would you like to do:"+'\n'+"1. Encrypt a message"+'\n'+"2. Decrypt a message"+'\n');
        String answer = scanObj.nextLine();
        switch (answer){
            case "1":
                Encrypt en = new Encrypt(scanObj);
                break;

            case "2":
                Decrypt de = new Decrypt(scanObj);
                break;

            default:
                System.out.println("Invalid choice, please enter either 1 or 2");
                break;
        }

    }


}

