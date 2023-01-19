package Greedy_Algorithm.Binary_Search;

public class Divid_Conquer {
    public static void main(String[] args) {
        int[] arr = new int[]{ 17, 28, 43, 67, 88, 92, 100 };
        System.out.println(search(arr,88));
    }
    private static boolean search(int[] arr, int num) {
        // 인덱스의 최소, 최대 값을 따로 저장하여 탐색이 진행될 때 마다 갱신하고 탐색

        // 반복문으로 구현
        // 각 최소, 최대, 중간위치 저장 변수 선언
        // 각각 배열의 인덱스를 나타냄
        // 최소 인덱스 ~> 당연히 0이겠지
        int min = 0;
        // 최대 인덱스 ~> 마지막 요소 위치
        int max = arr.length-1;
        // 중간 위치 저장
        int mid;

        // 배열의 최소, 최대 길이를 조건으로
        while (min <= max) {
            // 아 중간 위치를 반복으로 계속 나눠서 지정하는구나
            mid = (min + max) /2;
//            System.out.println(mid); // 홀수일 때 소숫점 내림하네
            // 배열의 해당 인덱스 요소가 num 과 같은 경우
            if (arr[mid] == num) return true;
            // 배열의 mid 인덱스 요소가 찾으려고 하는 숫자 보다 큰 경우
            else if (arr[mid] > num) max = mid - 1;
            // 위에 해당하지 않은 경우
            else min = mid + 1;
        }
        return false;
    }
}
// 참고 : https://cjh5414.github.io/binary-search/
// 흐름
// min = 0 / max = 7

// while
// mid = 7 + 0 / 2 = 3
// mid = 3
// arr[3] = 67
// 67 == 88 ? false
// 67 > 88 ? false
// min = 3 + 1 로 초기화

// while
// mid = 4 + 7 / 2 = 5
// arr[5] = 92
// 92 == 88 ? false
// 92 > 88 ? true
// max = 5 - 1

// while
// mid = 5 + 4 / 2 = 4
// arr[4] == 88
// 88 == 88 ? true
// return