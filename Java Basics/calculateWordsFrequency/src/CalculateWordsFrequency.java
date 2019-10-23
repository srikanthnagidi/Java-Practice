import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class CalculateWordsFrequency {
    public static void calculateWordsFrequency(List<String> input){
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        for (String str: input){
            treeMap.put(str, treeMap.getOrDefault(str, 0)+1);
        }
        for (String word:treeMap.keySet()){
            System.out.println(word + "|" + treeMap.get(word));
        }
    }

    public static void main(String[] args) {
        calculateWordsFrequency(Arrays.asList("abc", "bcs", "bcd", "bcs", "abc"));
    }
}
