import java.io.*;
import java.net.*;
import java.util.HashSet;
import java.util.Set;

public class Server {

    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream in = null;

    public Server(int port) {
        try {
            server = new ServerSocket(port);
            System.out.println("Server Started");
            System.out.println("Waiting for client...");
            socket = server.accept();
            System.out.println("Client Accepted");
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            String line = "";
            while (!line.equals("sziv")) {
                try {
                    line = in.readUTF();
                    System.out.println(line);
                    String[] splitMess = line.split(" ");
                    decrypt dec = new decrypt();
                    StringBuilder SB3 = new StringBuilder();
                    for(String b : splitMess){

                        String tempHolder = (dec.fuckTest(b));
                        SB3.append(tempHolder);
                        SB3.append(" ");
                    }
                    System.out.println(SB3.toString());


                } catch (IOException e) {
                    e.printStackTrace();
                }



            }
            System.out.println("Server Closing");
            socket.close();
            in.close();
            }catch(IOException e){
                throw new RuntimeException(e);
            }



        }



    public static void main(String[]args){
        Server server = new Server(12345);
    }
}

class cipherer{


    String ciphererDOER(String message, int key){
        StringBuilder SB = new StringBuilder();
        for(int i = 0; i < message.length(); i++){
            char ogChar = message.charAt(i);
            if(Character.isLetter(ogChar)){
                char base = Character.isLowerCase(ogChar) ? 'a':'A';
                int shifted = (ogChar - base +key) %26;
                char shiftedChar = (char)(base+(shifted+26)%26);
                SB.append(shiftedChar);

            }else{
                SB.append(ogChar);
            }
        }
        return SB.toString().replace("#","");
    }
}

class decrypt{
    private String message;
    public String fuckTest(String message) throws IOException {
        StringBuilder SB = new StringBuilder();
        engWordChecker checker = new engWordChecker();

        checker.loadDictionary("MyWordsNew.txt");



            for(int i = 0; i<=26; i++){
                cipherer ciph = new cipherer();
                if(checker.isEnglishWord(ciph.ciphererDOER(message, -i))){
                    SB.append(ciph.ciphererDOER(message,-i));
                    SB.append(" ");
                }



        }
        return SB.toString().replace("#","");
    }


}

class engWordChecker{
    private String message;
    private String fileName;
    private Set<String> dictionary;
    public engWordChecker() {
        this.message = message;
        this.fileName = "MyWordsNew.txt";
    }

    public Set<String> loadDictionary(String fileName) throws IOException {
        Set<String> dictionary = new HashSet<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;

        while ((line=reader.readLine()) != null){
            dictionary.add(line.trim().toLowerCase());
        }
        reader.close();
        return dictionary;
    }

    boolean isEnglishWord(String word) throws IOException {
        dictionary = loadDictionary("MyWordsNew.txt");
        String lowerCaseWord = word.toLowerCase();
        for(String dictWord : dictionary){
            if(dictWord.equals(lowerCaseWord)){
                return  true;
            }
        }
        return false;
    }



}