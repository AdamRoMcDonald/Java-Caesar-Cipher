import java.util.Scanner;

/**
 * @author Adam McDonald
 * @version 0.1
 * Encryption Option.
 */
public class Encrypt extends keyAndMessageObj{
    public Encrypt(Scanner scanObj){
        System.out.println("Please enter the message to encrypt: ");
        setMessage(scanObj.nextLine());
        System.out.println("Please enter the desired key: ");
        setKey(scanObj.nextInt());
        scanObj.nextLine();
        CaesarCipher CC = new CaesarCipher(getMessage(),getKey());


    }
}
