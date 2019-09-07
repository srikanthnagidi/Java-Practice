
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static boolean twoSum(int [] nums, int target){
        Map<Integer, Integer>  map = new HashMap<>();
        for  (int i=0; i<nums.length; i++){
            int counter =  target - nums[i];
            if (map.containsKey(counter)) return true;
            map.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(twoSum(new int [] {1, 3, 4, 2}, 8));
    }
}
