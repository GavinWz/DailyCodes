import java.io.*;
import java.net.*;
import java.util.Scanner;
public class Client{
    public static void main(String[] args) throws IOException{
        Socket client = new Socket("localhost", 8000);
        System.out.println("Input the radius.");
        Scanner in = new Scanner(System.in);
        double radius = in.nextDouble();
        DataInputStream fromServer = new DataInputStream(client.getInputStream());
        DataOutputStream toServer = new DataOutputStream(client.getOutputStream());
        toServer.writeDouble(radius);
        double area = fromServer.readDouble();
        System.out.println("Area is " + area);
    }
}