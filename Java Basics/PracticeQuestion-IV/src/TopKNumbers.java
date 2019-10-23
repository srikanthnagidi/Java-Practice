import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class TopKNumbers {

    public static List<Integer> topKNumbers (int [] nums, int k){
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : nums){
            set.add(i);
            if (set.size()>k) set.pollFirst();
        }
        return set.stream().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(topKNumbers(new int[] {2,3, 33, 23, 15, 9}, 4));
    }
}
