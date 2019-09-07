public class PermutationDemo {
    public static void printPermutn(int [] arr, int index){
        int size = arr.length;
        if (size == index+1) {
            for (int i : arr)System.out.print(i);
            System.out.println();
        }
        else {
            for (int i=index; i<size; i++){
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                printPermutn(arr, index+1);
            }
        }
    }
    public static void main(String [] args){
        int [] arr = new int[] {1, 3, 4, 5};
        printPermutn(arr, 0);
    }
}
