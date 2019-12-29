import java.util.*;

public class CountWords{
    public static void main(String[] args){
        String text = "Good morning. Have a good class. " + 
            "Have a good visit. have fun!";
        String[] words = text.split("[ ,.\'\";!?:]");
        Map<String, Integer> map = new LinkedHashMap<>();
        for(String word : words){
            if(word.length() > 0){
                word = word.toLowerCase();
                if(map.containsKey(word)){
                    int value = map.get(word) + 1;
                    map.put(word, value);
                }
                else{
                    map.put(word, 1);
                }
            }
        }
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        for(Map.Entry<String, Integer> entry : entrySet){
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
    }
}