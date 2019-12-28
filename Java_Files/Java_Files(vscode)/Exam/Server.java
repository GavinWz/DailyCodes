import java.io.*;
import java.net.*;
public class Server{
    public static void main(String[] args){
        try{
            ServerSocket server = new ServerSocket(8000);
            Socket socket = server.accept();
            DataInputStream fromServer = new DataInputStream(socket.getInputStream());
            DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());
            while(true){
                double radius = fromServer.readDouble();
                // double area = Math.PI * radius * radius;
                double area = Math.PI * Math.pow(radius, 2);
                System.out.println("Area is " + area);
                toServer.writeDouble(area);
            }
        }catch(IOException ex){}
    }
}