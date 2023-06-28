/**
 * THIS CODE IS NOT IN USE ANYMORE, IT WAS MADE IRRELEVANT
 */


import java.util.HashMap;
import java.util.Map;

/**
 * @author Adam McDonald
 * @version 0.1
 * <p>This class does the actually encryption/decryption. </p>
 */

public class CaesarCipher{
    public CaesarCipher(String message, int key){
        /**
         * A Map is used to attack each letter of the alphabet to a number, the number being the key and the letter the object.
         */

        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(0,"a");
        map.put(1,"b");
        map.put(2,"c");
        map.put(3,"d");
        map.put(4,"e");
        map.put(5,"f");
        map.put(6,"g");
        map.put(7,"h");
        map.put(8,"i");
        map.put(9,"j");
        map.put(10,"k");
        map.put(11,"l");
        map.put(12,"m");
        map.put(13,"n");
        map.put(14,"o");
        map.put(15,"p");
        map.put(16,"q");
        map.put(17,"r");
        map.put(18,"s");
        map.put(19,"t");
        map.put(20,"u");
        map.put(21,"v");
        map.put(22,"w");
        map.put(23,"x");
        map.put(24,"y");
        map.put(25,"z");

        /**
         * <p>The following code splits the user's message into an Array so each letter can be addressed individually.
         * It verifies that the letter is present in the English alphabet, and finds the (Map) key for the same letter and adds the (user given) key to it.
         * It then finds the value of the new (Map) key and adds that letter to a StringBuilder.
         * For example, if the (User) key was 4, and the letter was "A", then and "E" would be added to the StringBuilder </p>
         */

        String[] splitMessage = message.split("");
        StringBuilder sBuild = new StringBuilder();
        String helpMe;
        for(String c : splitMessage){
            if (map.containsValue(c))
                for(Integer a : map.keySet()){
                    if (c.equals(map.get(a))) {
                        helpMe = map.get(a + key);
                        sBuild.append(helpMe);


                    }


                }





        }
        if(key<0) System.out.println("Decrypted message: "+sBuild.toString());
        else System.out.println("Encrypted message: "+sBuild.toString());






    }


}

