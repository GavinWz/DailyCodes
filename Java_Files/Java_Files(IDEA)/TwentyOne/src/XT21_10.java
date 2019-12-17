import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class XT21_10 {
    public static void main(String[] args) throws FileNotFoundException {
        Map<String, Integer> map = new TreeMap<>();
        String word = "abstract\tassert\tboolean\tbreak\tbyte\n" +
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
//        for(String test : words)
//            System.out.println(test);
//        Scanner in = new Scanner(System.in);
//        System.out.printf("Input filename: ");
//        String filename = in.nextLine();
        String filename = "C:\\Users\\Gavin\\Desktop\\Files\\装备.txt";
        File file = new File(filename);
        Scanner get_words = new Scanner(file);
        while(get_words.hasNext()){
            String sentence = get_words.nextLine();
            System.out.println();
//            System.out.println(sentence);
            String[] get = sentence.split("[ ,;/:?><(){}|&%!=+'\t\n\\.\\-]");
            for(String get_word : get) {
                if(get_word.length() == 0)
                    continue;
                if (judgeContains(words, get_word)) {
                    if(map.containsKey((get_word)))
                        map.put(get_word, map.get(get_word) + 1);
                    else
                        map.put(get_word, 1);
                }
            }
        }
        Set<Map.Entry<String, Integer>> set = map.entrySet();
        for(Map.Entry<String, Integer> print : set){
            System.out.println(print.getValue() + " " + print.getKey());
        }


    }

    public static boolean judgeContains(String[] words, String word) {
        for(String temp : words){
            if(temp.equals(word))
                return true;
        }
        return false;
    }
}
