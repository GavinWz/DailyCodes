import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class Exercise21_13{
    
    public static void main(String[] args) throws FileNotFoundException{
        Scanner in = new Scanner(System.in);
        String[] names = new String[5];
        
        while(true){
            System.out.print("Enter the year: ");
            String year = in.nextLine();
            System.out.print("Enter the gender: ");
            String gender = in.nextLine();
            System.out.print("Enter the name: ");
            String name = in.nextLine();
            String filename = "..//Document//babynameranking" + year + ".txt";
            File file = new File(filename);
            Scanner scan = new Scanner(file);
            while(scan.hasNext()){
                int i = 0;
                String[] read = scan.nextLine().split("[ \t\n]");
                for(String temp : read){
                    if(temp.length() != 0){
                        names[i] = temp;
                        i++;
                    }
                }

                if(gender.equals("M")){
                    if(names[1].equals(name)){
                    System.out.println("Boy name " + name +" is ranked #" + 
                    names[2] + " in year " + year);
                    break;
                    }
                }
                if(gender.equals("F")){
                    if(names[3].equals(name)){
                    System.out.println("Girl name " + name +" is ranked #" + 
                    names[4] + " in year " + year);
                    break;
                    }
                }
            }
            System.out.println("Enter another inquiry?");
            String judge = in.nextLine();
            while(judge.charAt(0) != 'Y' && judge.charAt(0) != 'y' && 
                    judge.charAt(0) != 'N' && judge.charAt(0) != 'n'){
                System.out.println(judge.charAt(0) + " " +"Please Enter Y/y or N/n");
                judge = in.nextLine();
                in.nextLine();
            }
            if(judge.charAt(0) == 'N' || judge.charAt(0) == 'n')
                break;
        }
    }
}