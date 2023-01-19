package Time_Complextity;

public class O2n {
    public static void main(String[] args) {
        System.out.println(fibonacci(50));
    }
    public static int fibonacci(int n) {
        if (n <= 1) {
            return 1;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }
}
// 40으로 두면 몇초 걸리는데 50으로 두면 트리구조라 1분? 걸리는듯
// 1000이면? 진자 평생 못받을수도 ㅋㅋㅋ
// 이거 근데 궁금해서 몇 년동안 켜놔본 사람 있을거 같음 ㄹㅇㅋㅋ