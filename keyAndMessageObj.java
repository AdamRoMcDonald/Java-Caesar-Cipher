import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Adam McDonald
 * @version 0.2
 * <p>This class creates a new object which holds a string message (from user input) and numerical key from the same source.
 * It also has the actual method for decoding or encoding a message with the Caesar cipher.2</p>
 */
public class keyAndMessageObj{
    String message;
    int key;
    private Set<String> dictionary;
    public keyAndMessageObj(){
        this.message = message;
        this.key = key;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public int getKey() {
        return key;
    }
    public void setKey(int key) {
        this.key = key;
    }

    /**
     * public void EnglishWordChecker takes a String for a filepath name and loads it to a sorted Set<String>
     * @param dictionaryFilePath A string which represents the name of the file from which words are being drawn. In this case, the filename is "words.txt".
     * @throws IOException File not found exception.
     * @see https://github.com/dwyl/english-words
     */
    public void EnglishWordChecker(String dictionaryFilePath) throws IOException {
        dictionary = loadDictionary(dictionaryFilePath);
    }

    /**
     * public Set<String> loadDictionary(String dictionaryFilePath) Initializes the dictionary Set<> and populates it with all words from the reference file. (words.txt)
     * @param dictionaryFilePath
     * @return
     * @throws IOException
     */
    public Set<String> loadDictionary(String dictionaryFilePath) throws IOException {
        Set<String> dictionary = new HashSet<>();
        BufferedReader reader = new BufferedReader(new FileReader(dictionaryFilePath));
        String line;

        /**
         * Sets all letters to lowercase and trims for ease of processing.
         */

        while ((line = reader.readLine()) != null) {
            dictionary.add(line.trim().toLowerCase());
        }
        reader.close();
        return dictionary;
    }

    /**
     * public boolean isEnglishWord very simply checks if the given message (from user) is present in the dictionary Set and would thus be an English word.
     * @param word Represents the user message.
     * @return Returns true if the user message is an English word, and false if not.
     */
    public boolean isEnglishWord(String word) {
        String lowercaseWord = word.toLowerCase();
        return dictionary.contains(lowercaseWord);
    }


    /**
     * This is the method which actually does the ciphering/deciphering.
     * @param message
     * @param key
     * @return
     * @throws UnsupportedEncodingException
     * <p>Splits the user message into an array of single letter strings, changes each element in the array into the corresponding ASCII number,
     * adds the key to said number, turns each individual element back into the new corresponding ASCII character, and then reconstructs the word in a StringBuilder object.
     */


    public String CaesarCipher(String message, int key) throws UnsupportedEncodingException {
        String[] test = message.split("");
        StringBuilder sB = new StringBuilder();
        for (String c : test) {
            char a = c.charAt(0);
            int ascii = (int)a+key;
            char asciiToChar = (char) ascii;
            sB.append(asciiToChar);
        }
        return sB.toString().replace("#"," ");
        }
    }


