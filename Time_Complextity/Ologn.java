package Time_Complextity;

public class Ologn {
    public static void main(String[] args) {
        System.out.println(log(50));
    }
    public static int log(int n) {
        int i = n;
        while (i > 0) {
            i /= 2;
        }
        return i;
    }
}
// 이런식으로 이전 수를 버리고 연산 반복하면 O(log n)