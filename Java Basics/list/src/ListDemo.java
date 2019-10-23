import java.util.*;

public class ListDemo {
    public static List<String> [] groupString (List <String>  input){
        Map<Character,  List<String>> map= new HashMap<>();
        for (String st : input){
            if (map.containsKey(st.charAt(0))){
                List<String> y = map.get(st.charAt(0));
                List<String> x = new ArrayList<>();
                x.addAll(y);
                x.add(st);
                //System.out.print(y);
                map.put(st.charAt(0), x);
            }else {
                List <String> x = Arrays.asList(st);
                map.put(st.charAt(0), x);
            }
        }
        List <List<String>> ans = new ArrayList<>();
        for (Map.Entry<Character, List<String>> entry : map.entrySet()){
            ans.add(entry.getValue());
        }
        List<String> [] ans2 = new List[ans.size()];
        return ans.toArray(ans2);
    }

    public static void main(String[] args) {
        List<String> input = Arrays.asList("abc", "bcd", "bbb", "ace", "snb", "aaaa", "bbbbb", "eeee");
        for (List<String> lst : groupString(input)) {
            System.out.println(lst);
            System.out.println();
        }
    }
}
