package Greedy_Algorithm.Bruto_Force;

import java.util.Arrays;

public class Selection_Sort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(SelectionSort(new int[]{9, 4, 8, 3, 1, 5})));
    }
    private static int[] SelectionSort(int[] arr) {
        // 주어진 배열을 오름차순 정렬하기 위함
        // 입력 : 정렬 가능한 요소의 배열
        // 출력 : 오름차순으로 정렬된 배열

        // 배열의 0번째 인덱스부터 마지막 인덱스까지 반복
        for (int i = 0; i < arr.length - 1; i++) {
            // 현재 인덱스를 최소값의 인덱스를 타나내는 변수에 할당
            int min = i;
            //현재 i에 1을 더해 i 이후의 배열 요소와 비교하는 반복문
            for (int j = i + 1; j < arr.length; j++) {
                // j 인덱스의 배열 요소가 min 인덱스의 배열 요소보다 작은 경우
                if (arr[j] < arr[min]) {
                    // 최소를 나타내는 값 변경
                    min = j;
                }
            }
            // 모든 비교가 끝나면
            // min 에는 최소값이 들어가 있으니 i 값과 최소값을 바꿔서 할당
            int x = arr[i];
            arr[i] = arr[min];
            arr[min] = x;
        }
        // 정렬된 배열 반환
        return arr;
    }
}
