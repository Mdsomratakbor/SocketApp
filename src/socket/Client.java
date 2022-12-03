package socket;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    
    /**
     * @param args
     * @throws IOException
     */
    public static void main (String []args) throws IOException{
        Socket socket = new Socket("localhost", 5243);
        System.out.println("Connection Successfully Builed");    
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());
        Scanner scanner = new Scanner(System.in);
        String string = "";
        while(!string.equals("Bye")){
            string = scanner.nextLine();
            output.writeUTF(string);
        }
        output.close();
        socket.close();
        System.out.println("Connection Closed");

    }
}
