import java.util.Scanner;

/**
 * @author Adam McDonald
 * @version 0.1
 * Decryption Option.
 */

public class Decrypt extends keyAndMessageObj{
    public Decrypt(Scanner scanObj){
        System.out.println("Please enter the message to decrypt: ");
        setMessage(scanObj.nextLine());
        System.out.println("Please enter the desired key: ");
        int keyForDecrypt = scanObj.nextInt();
        /**
         * To de-encrypt a message, the opposite key must be used.
         */
        setKey(-keyForDecrypt);

        scanObj.nextLine();
        CaesarCipher CC = new CaesarCipher(getMessage(),getKey());


    }
}