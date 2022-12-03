package socket;
import java.io.DataInput;
import java.io.DataInputStream;
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
        try (Socket socket = new Socket("localhost", 5943)) {
            System.out.println("=========Connection Successfully Builed==========");    

            System.out.println("\n@@@=====Please start your conversation with server=====@@@");    
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            DataInput input = new DataInputStream(socket.getInputStream());
            Scanner scanner = new Scanner(System.in);
            String string = "", serverString = "";
            while(!string.equals("Bye")){
                string = scanner.nextLine();
                output.writeUTF(string);
                output.flush();
                serverString = input.readUTF();
                System.out.println("Server Says: "+serverString);
            }
            output.close();
            socket.close();
            scanner.close();
            
        }
        System.out.println("!!!!!!!!!--------Connection Closed--------!!!!!!!!!");

    }
}
