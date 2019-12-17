import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Exercise21_10{
    public static void main(String[] args) throws FileNotFoundException {
        Map<String, Integer> map = new TreeMap<>();
        String word = "abstract\tassert\tboolean\tbreak\tbyte\n" +
                "String\tint\tInteger\t"+
                "case\tcatch\tchar\tclass\tconst\n" +
                "continue\tdefault\tdo\tdouble\telse\n" +
                "enum\textends\tfinal\tfinally\tint\tfloat\n" +
                "for\tgoto\tif\timplements\timport\n" +
                "instanceof\tint\tinterface\tlong\tnative\n" +
                "new\tpackage\tprivate\tprotected\tpublic\n" +
                "return\tstrictfp\tshort\tstatic\tsuper\n" +
                "switch\tsynchronized\tthis\tthrow\tthrows\n" +
                "transient\ttry\tvoid\tvolatile\twhile";
        String words[] = word.split("[ \t\n+]");
        String filename = "Exercise21_8.java";
        File file = new File(filename);
        Scanner get_words = new Scanner(file);
        while(get_words.hasNext()){
            String temp = get_words.nextLine();
            if(temp.length() == 0)
                continue;
            // System.out.println(temp);
            String sentence = temp;
            String[] get = sentence.split("[ ,;/:?><(){}|&%!=+'\t\n\\.\\-]");
            for(int i = 0; i < get.length; i++) {
                if(get[i].length() == 0)
                    continue;
                if(get[i].equals("\\\\"))
                    break;
                if(get[i] == "\""){
                    i++;
                    while(get[i] != "\"")
                        i++;
                }
                if(get[i] == "\\*"){
                    i++;
                    while(get[i] != "/*")
                        i++;
                }
                if (judgeContains(words, get[i])) {
                    if(map.containsKey((get[i])))
                        map.put(get[i], map.get(get[i]) + 1);
                    else
                        map.put(get[i], 1);
                }
            }
        }
        Set<Map.Entry<String, Integer>> set = map.entrySet();
        for(Map.Entry<String, Integer> print : set){
            System.out.println(print.getValue() + " " + print.getKey());
        }
    }

    public static boolean judgeContains(String[] words, String word){
        for(String temp : words){
            if(temp.equals(word))
                return true;
        }
        return false; 
    }
}