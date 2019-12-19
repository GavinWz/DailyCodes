import java.net.*;
import java.util.Scanner;
import java.io.*;
public class Client{
    public static void main(String[] args){
        try{
            Socket socket = new Socket("192.168.43.152", 8000);
            DataInputStream fromServer = new DataInputStream(socket.getInputStream());
            DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());
            Scanner in = new Scanner(System.in);
            while(true){
                double radius = in.nextDouble();
                toServer.writeDouble(radius);
                toServer.flush();
                Double area = fromServer.readDouble();
                System.out.println("Area = " + area);
            }
        }catch(IOException ex){}
    }
}


