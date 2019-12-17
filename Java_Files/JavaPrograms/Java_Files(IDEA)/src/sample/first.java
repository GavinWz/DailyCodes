package sample;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class first {
//    public static Map sort(Map map) {
//        Set<Map.Entry<String, Integer>> set;
//        Map newMap = new TreeMap();
//        set = map.entrySet();
//        for (int i = 0; i < set.size(); i++){
//            String compare = "a";
//            for(Map.Entry<String, Integer> temp : set){
//                System.out.println(temp.getKey()+" " + compare);
//                if(temp.getKey().compareTo(compare) >= 0){
//                    System.out.println("da");
//                    compare = temp.getKey();
//                }
//                else
//                    System.out.println("xiao");
//            }
//            newMap.put(compare, map.get(compare));
//            map.remove(compare);
//            System.out.println();
//        }
//        return newMap;
//    }

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
//        Map newmap = sort(map);

        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        for(Map.Entry<String, Integer> each : entrySet){
            System.out.println(each.getValue() + "  " + each.getKey());
        }
    }

}
