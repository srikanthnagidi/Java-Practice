public class BinarySearchDemo {
    public static int findTarget(int [] array, int target){
        if (array.length == 0) return -1;
        int start =0, end = array.length -1;
        while (start + 1< end){
            int mid = start + (end-start)/2;
            if (array[mid] == target) return mid;
            else if(array[mid]>target){
                end =mid;
            }else{
                start = mid;
            }
        }
        if (array[start] == target){
            return start;
        }
        if (array[end] == target){
            return end;
        }
        return -1;
    }
}

