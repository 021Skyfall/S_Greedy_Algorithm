package Time_Complextity;

public class On {
    public static void main(String[] args) {
        O_n_algorithm(123456789);
        another_O_n_algorithm(95484215);
    }
    public static void O_n_algorithm(int n){
        for (int i = 0; i < n; i++) {
            System.out.print(1);
        }
    }
    public static void another_O_n_algorithm(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(2);
        }
    }
}
// 아니 하루종일 걸리는디 ㅋㅋㅋㅋㅋ
// 한 5분 지나도 1 출력 중임 계속 켜놔봤는데 ㅋㅋㅋ
// 보통 순회가 한번씩 이루어지면 O(n)