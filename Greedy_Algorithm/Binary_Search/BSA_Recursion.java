package Greedy_Algorithm.Binary_Search;

public class BSA_Recursion {
    public static void main(String[] args) {
        int[] arr = new int[]{ 17, 28, 43, 67, 88, 92, 100 };
        System.out.println(search(arr,88,0,arr.length-1));
    }
    private static boolean search(int[] arr, int num, int min, int max) {
        // 재귀 호출 끝나면 false 갖고 탈출
        if (min > max) return false;
        // 배열의 중간 인덱스 값 설정
        int mid = (min + max) / 2;
        // 찾는 값 있으면 true
        if (arr[mid] == num) return true;
        // arr 배열의 mid 인덱스 요소보다 num 이 작으면 max-1 하면서 재귀호출
        else if (arr[mid] > num) return search(arr,num,min,max-1);
        // 아니면 min + 1 재귀
        else return search(arr,num,min+1,max);
    }
}
// 흐름
// mid = 0 + 7 / 2 = 3
// 67 == 88 ? false
// 67 > 88 ? false
// min + 1 재귀

// mid = 1 + 7 / 2 = 4
// 88 == 88? true
// 재귀 탈출 후 true
// return true

// 이게 더 빨리 찾네
// 근데 이건 운좋게 걸린 그런 모양새라
// 결국 데이터 값 늘어나면 반복문으로 한거랑 시간복잡도는 비슷할듯