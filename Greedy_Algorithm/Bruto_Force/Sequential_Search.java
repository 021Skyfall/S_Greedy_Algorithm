package Greedy_Algorithm.Bruto_Force;

public class Sequential_Search {
    public static void main(String[] args) {
        int[] arr = new int[]{2,31,52,32,32,12,54,66,52,4,4,5,5,21,6,5,3,4};
        System.out.println(SearchNum(arr,21));
    }
    private static boolean SearchNum(int[] arr, int num) {
        for (int i : arr) {
            if (i == num) {
                return true;
            }
        }
        return false;
    }
}
