import java.util.HashMap;
import java.util.Map;

public class FindDuplicate {
    public static int findDuplicate(String input){
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<input.length(); i++){
            if (map.containsKey(input.charAt(i))) return i;
            else{
                map.put(input.charAt(i), null);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate("abcabc"));
        System.out.println(findDuplicate("abcd"));
    }
}
