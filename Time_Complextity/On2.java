package Time_Complextity;

public class On2 {
    public static void main(String[] args) {
        O_quadratic_algorithm(10);
        another_O_quadratic_algorithm(50);
    }
    public static void O_quadratic_algorithm(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(1);
            }
        }
    }
    public static void another_O_quadratic_algorithm(int n) {

        for(int i = 0; i < n; i++) {
            System.out.println();
            for (int j = 0; j < n; j++) {
                System.out.print(2);
            }
            System.out.println();
            for (int k = 0; k < n; k++) {
                System.out.print(3);
            }
            System.out.println();
            for (int l = 0; l < n; l++) {
                System.out.print(4);
            }
        }
    }
}
// 연산이 제곱수로 이루어진다
// 즉, 순회가 중첩되서 발생하면 O(n^2)