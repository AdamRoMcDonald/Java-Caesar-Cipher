import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    // initialize socket and input output streams
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream out = null;

    // constructor to put ip address and port
    public Client(String address, int port)
    {
        // establish a connection
        try {
            socket = new Socket(address, port);
            System.out.println("Connected");

            // takes input from terminal
            input = new DataInputStream(System.in);

            // sends output to the socket
            out = new DataOutputStream(
                    socket.getOutputStream());
        }
        catch (UnknownHostException u) {
            System.out.println(u);
            return;
        }
        catch (IOException i) {
            System.out.println(i);
            return;
        }

        // string to read message from input
        String line = "";

        // keep reading until "Over" is input
        while (!line.equals("Over")) {
            try {
                line = input.readLine();

                cipherer ciph = new cipherer();
                String[] splitMessage = line.split(" ");
                StringBuilder SB2 = new StringBuilder();
                for(String c : splitMessage){
                    String idk = ciph.ciphererDOER(c, 4);
                    SB2.append(idk);
                    SB2.append(" ");
                }



                out.writeUTF(SB2.toString());
            }
            catch (IOException i) {
                System.out.println(i);
            }
        }

        // close the connection
        try {
            input.close();
            out.close();
            socket.close();
        }
        catch (IOException i) {
            System.out.println(i);
        }
    }

    public static void main(String args[])
    {
        Client client = new Client("192.168.1.4", 12345);
    }
}

class cipherer{


    String ciphererDOER(String message, int key) {
        StringBuilder SB = new StringBuilder();


            for (int i = 0; message.length() > i; i++) {
                char ogChar = message.charAt(i);
                if (Character.isLetter(ogChar)) {
                    char base = Character.isLowerCase(ogChar) ? 'a' : 'A';
                    int shifted = (ogChar - base + key) % 26;
                    char shiftedChar = (char) (base + (shifted + 26) % 26);
                    SB.append(shiftedChar);

                }




        }
        return SB.toString().replace("#", "");
    }
}