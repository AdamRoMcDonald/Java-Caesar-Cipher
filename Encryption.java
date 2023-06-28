import java.util.Scanner;
import java.io.IOException;

/**
 * @author Adam McDonald
 * @version 0.2
 * <p>Encryption class deals with the encryption choice by user. Gets key and message and sets them.</p>
 */

public class Encryption{
    public Encryption(Scanner scanObj) throws UnsupportedEncodingException {
        keyAndMessageObj MKPair = new keyAndMessageObj();
        System.out.println("Please enter the message to encrypt: ");
        MKPair.setMessage(scanObj.nextLine());
        System.out.println("Please enter the desired key: ");
        MKPair.setKey(scanObj.nextInt());
        scanObj.nextLine();
        System.out.println("Your message encrypted to a key of "+MKPair.getKey()+" : "+MKPair.CaesarCipher(MKPair.getMessage(), MKPair.getKey()));
    }
}
