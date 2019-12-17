

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class test {
    public static void main(String[] args){
        String text = "Good morning teacher, I do have gone to your class today!";
        Map<String, Integer> map = new TreeMap<>();
        String[] words = text.split("[ ,;.:?'\"()]");
        for(String word : words){
            word = word.toLowerCase();
            if(word.length() > 0){
                if(map.containsKey(word)){
                    map.put(word, map.get(word) + 1);
                }
                else {
                    map.put(word, 1);
                }
            }
        }

        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        for(Map.Entry<String, Integer> each : entrySet){
            System.out.println(each.getValue() + "  " + each.getKey());
        }
    }

}
