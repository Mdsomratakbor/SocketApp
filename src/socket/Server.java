package socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String []args) throws IOException{
        ServerSocket serverSocket = new ServerSocket(5243);
        System.out.println("Server is wating for client");
        Socket socket = serverSocket.accept();
        System.out.println("Client request is accepted");
        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
        String  string = "";
        while(!string.equals("Bye")){
            string = inputStream.readUTF();
            System.out.println("Client says: "+string);
        } 
        inputStream.close();
        serverSocket.close();

    }
}
