import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{
    public static void main(String[] args){
        try{
            ServerSocket serverSocket = new ServerSocket(8000);
            Socket socket = serverSocket.accept();
            DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
            DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());
            while(true){
                double radius = inputFromClient.readDouble();
                System.out.println("Radius = " + radius);
                if(radius < 0){
                    socket.close();
                    serverSocket.close();
                    break;
                }
                double area = Math.PI * radius *radius;
                outputToClient.writeDouble(area);
                System.out.println("Area = " + area);
            }
        }catch(IOException ex){}

    }
}