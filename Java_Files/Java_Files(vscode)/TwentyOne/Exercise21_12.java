import java.io.File;
import java.util.Map;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
public class Exercise21_12{
    public static void main(String[] args)  throws FileNotFoundException{
        Scanner in = new Scanner(System.in);
        String[] names = new String[5];
        String[] read;
        Set<String> boys = new TreeSet<>();
        Set<String> girls = new TreeSet<>();
        Set<String> equal = new TreeSet<>();
        int number = 0;
        String filename = in.nextLine();
        // String filename = "babynameranking2001.txt";
        File file = new File(filename);
        Scanner get_words = new Scanner(file);
        while(get_words.hasNext()){
            int i = 0;
            read = get_words.nextLine().split("[ \t\n]");
            for(String name : read){
                if(name.length() != 0){
                    names[i] = name;
                    i++;
                }
            }
            boys.add(names[1]);
            girls.add(names[3]);
        }
        for(String boy_temp : boys){
            for(String girl_temp : girls){
                if(boy_temp.contains(girl_temp)){
                    equal.add(girl_temp);
                    number++;
                }
            }
        }
        System.out.println(number + " names used for both genders.");
        System.out.println("They are " + equal);
    }
}