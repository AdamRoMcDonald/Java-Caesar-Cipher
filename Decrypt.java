import java.util.Scanner;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @author Adam McDonald
 * @version 0.2
 * <p>Decryption class deals with encryption choice by user. Gets key and message and sets them.</p>
 */
public class Decrypt{
    public Decrypt(Scanner scanObj) throws IOException {


        keyAndMessageObj MKPair = new keyAndMessageObj();
        MKPair.EnglishWordChecker("words.txt");
        System.out.println("Please enter the message to de-encrypt: ");
        MKPair.setMessage(scanObj.nextLine());

        /**
         *If user does not know the key, this code iterates through all possible keys (26) and checks them using the dictionary.2
         *@see The loadDictionary, isEnglishWord, and EnglishWordChecker methods in keyAndMessageObj class.
         */
        
        boolean idk = true;
        idk = true;
        while(idk) {
            System.out.println("Do you know the key? Y/N: ");
            String knowKeyAnswer = scanObj.nextLine();
            switch (knowKeyAnswer) {
                case "N" -> {
                    for (int i = 0; i <= 26; i++) {
                        if (MKPair.isEnglishWord(MKPair.CaesarCipher(MKPair.getMessage(), -i))) {
                            System.out.println("It appears that your message, " + MKPair.getMessage() + " turns into: " + MKPair.CaesarCipher(MKPair.getMessage(), -i));
                            idk = false;
                        }
                    }
                }
                case "Y" -> {
                    System.out.println("Please enter the desired key: ");
                    MKPair.setKey(-scanObj.nextInt());
                    scanObj.nextLine();
                    System.out.println("Your message decrypted to a key of " + MKPair.getKey() + " : " + MKPair.CaesarCipher(MKPair.getMessage(), MKPair.getKey()));
                    System.out.println("Would you like to continue to main menu or exit? (E for exit, C for continue): ");
                    idk = false;


                }
                default -> {
                    System.out.println("Sorry, that's not a valid input. Please enter either Y for yes, or N for no. ");
                    idk = true;
                }


            }
        }
        
    }
}
