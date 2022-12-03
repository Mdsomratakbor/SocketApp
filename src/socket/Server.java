package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String []args) throws IOException{
        ServerSocket serverSocket = new ServerSocket(5943);
        System.out.println("=========Server is wating for client=========");
        Socket socket = serverSocket.accept();
        System.out.println("@@@=====Client request is accepted=====@@@");
        System.out.println("###=====Wating for Client Message=====###");
        DataInputStream inputStream = new DataInputStream(socket.getInputStream());

        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
       try (Scanner scanner = new Scanner(System.in)) {
        String  string = "", clientString = "";
        while(!string.equals("Bye")){
            string = inputStream.readUTF();
            System.out.println("Client says: "+string);
            clientString = scanner.nextLine();
            outputStream.writeUTF(clientString);
            outputStream.flush();
        }
    }
        inputStream.close();
        serverSocket.close();
        outputStream.close();
        socket.close();
        System.out.println("!!!!!!!!!--------Connection Closed--------!!!!!!!!!");
    }
}
