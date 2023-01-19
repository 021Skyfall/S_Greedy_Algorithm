package Time_Complextity;

public class O1 {
    public static void main(String[] args) {
//        int[] arr = new int[250000000];
//        for (int i = 0; i < 250000000; i++) {
//            arr[i] = i+100;
//        }
        int[] arr = new int[]{1,2,3,4,5};
        int index = 3;
        int results = O_1_algorithm(arr, index);
        System.out.println(results);
    }
    public static int O_1_algorithm(int[] arr, int index) {
        return arr[index];
    }
}
// 이렇게 하니까 비교적 좀 버벅대는데 ㅋㅋㅋ 이건 내 하드웨어 문젠가
// 아 이거 근데 생각해보니까 for 연산을 하기 때문에 O(n) 시간복잡도 인듯
// 값을 그대로 출력해주는게 O(1) 인거 같음
// 다시 바꿈