package Math_Algorithm.Coplit;

import java.util.*;
import java.util.stream.Collectors;

public class d_11day {
    public static void main(String[] args) {
        System.out.println(divideChocolateStick(4, 8));
    }
    private static ArrayList<Integer[]> divideChocolateStick(int M, int N) {
        // [빼빼로를 받게 되는 직원의 수, 나누어 주는 아몬드 빼빼로의 수, 나누어 주는 누드 빼빼로의 수]
        // '빼빼로를 받게 되는 직원의 수'를 기준으로 오름차순으로 정렬
        // 직원 수는 1 부터 매개변수 둘 중 하나가 1이 될때까지의 정수
        // 해당 값과 M과 N 이 나누어 떨어져야함
        // 이외에는 아무것도 하지 않음
        // 최대공약수 활용 문제
        // 최대공약수 -> 두 수의 약수 중 공통된 최대 약수
        // ex)
        // 12 -> 1 2 3 4 6 12
        // 18 -> 1 2 3 6 9 18
        // 최대공약수 = 6
        // 최소공약수는 어떤 수든 1임
        // 최소공배수 -> 두 수의 배수 중 공통된 최소 배수
        // ex)
        // 10 -> 20 30 40 50 60 70
        // 20 -> 40 60 80 100
        // 최소공배수 = 60
        // 최대공배수는 어떤 수든 ∞임

        // 결과를 담아줄 리스트 생성
        ArrayList<Integer[]> result = new ArrayList<>();
        // 최대공약수 구함
        int GCD = gcd(M,N);
        // 약수는 대칭하기 떄문에 제곱근까지만 반복 ~> 제곱근 보다 큰 약수는 제곱근보다 작은 약수에서 구할 수 있음
        int sqrt = (int) Math.floor(Math.sqrt(GCD));
        for (int i = 1; i <= sqrt; i++) {
            // 최대공약수의 약수인 경우 중 제곱근 보다 작은 약수의 경우
            if (GCD % i == 0) {
                result.add(new Integer[]{i,M/i,N/i});
                // 제곱근이 아닌 경우
                if (i * i < GCD) {
                    // 최대 공약수를 제곱근이 아닌 수로 나누면 제곱근 보다 큰 약수를 구할 수 있음
                    int j = GCD / i;
                    result.add(new Integer[]{j,M/j,N/j});
                }
            }
        }
        // 오름차순 정렬 / 직원을 기준으로 함
        result.sort(Comparator.comparing(o -> o[0]));
        return result;
    }
    // 최대공약수를 구하기 위해 유클리드 호제법 사용
     private static int gcd(int p, int q) {
    	if (q == 0) return p;
    	return gcd(q, p%q);
     }
}
/* 흐름
* M과 N이 동시에 나누어 떨어지는 상황을 리스트에 담는 것이 해당 문제의 요지임
* 그렇다면 M과 N의 최대공약수의 약수들이 해당 상황과 같음
*
* 4, 8 가정
* 4 -> 1 2 4
* 8 -> 1 2 4 8
* gcd() = 4
* 4의 제곱근은 2
* for 에서 i = 1 인 이유는 최소공약수는 1이기 때문
* 1 부터 2 까지 반복문 실행하는 이유는 어차피 약수는 해당 수의 제곱근의 대칭되는 수이기 때문
*
* 4의 최소 약수
* if 4 % 1 == 0 true
* result = [1,4,8]
*
* 해당 약수와 대칭되는 약수
* if 1*1 < 4 true
* j = 4 / 1
* result = [1,4,8],[4,1,2]
*
* 4의 다음 약수
* for 2
* if 2 % 1 == 0 true
* result = [1,4,8],[4,1,2],[2,2,4]
*
* 대칭되는 약수
* if 2*2 < 4 false
*
* result 각 객체의 0번째 인덱스를 비교후 오름차순 sort()
 */