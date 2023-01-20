package Greedy_Algorithm.Coplit;

public class b_PartTimeJob {
    public static void main(String[] args) {
        System.out.println(partTimeJob(4972));
    }
    public static int partTimeJob(int k) {
        // 가진 동전 1원, 5원, 10원, 50원, 100원, 500원
        // 매개변수 k 를 가진 동전으로 환산
        // 단, 환산되는 동전의 개수는 최소값이어야함

        // 가장 큰 값으로 우선 환산 반복
        // 환산 종료 후 합이 k 보다 크면 가장 마지막 동전 삭제, 한 단계 작은 동전으로 다시 반복
        // 환산 종료 후 합이 k 보다 작으면 다시 반복

        // 계산하기 위한 동전 배열
        // 큰값부터 환산할 거니까 거꾸로 넣을거임
        int[] coin = new int[]{500,100,50,10,5,1};
        // 총 동전 개수
        int count = 0;
        // 환산 시작 ~> coin 에서 순서대로 요소 빼와야함
        for (int i : coin) {
            // k / 현재 동전 (i) = 해당 동전이 필요한 갯수
            count += k/i;
            // 동전을 센 금액 만큼 제외 후 다시 루프
            // (인트형에 나눗셈 들어가면 정수만 취하고 소숫점 아래는 버려지는거 잊지말고)
            k -= (k/i) * i;
        }
        return count;
    }
}
// 흐름
/*
* count 0
* for
* i 500
* 0 += 4972 / 500 -> count = 9
* 4972 -= (4972/500) * 500 -> 9 * 500 -> k = 472
* for
* i 100
* 9 += 472 / 100 -> count = 13
* 472 -= (472/100) * 100 -> 4 * 100 -> k = 72
* for
* i 50
* 13 *= 72 / 50 -> count = 14
* 72 -= (72/50) * 50 -> 1 * 50 -> k = 22
* for
* i 10
* 14 += 22 / 10 -> count = 16
* 22 -= (22/10) * 10 -> 2 * 10 -> k = 2
* for
* i 5
* 16 += 2 / 5 -> count = 16
* 2 -= (2/5) * 5 -> 0 * 5 -> k = 2
* for
* i 1
* 16 *= 2 / 1 -> count = 18
* 2 -= (2/1) * 1 -> 2 * 1 -> k = 0
* 탈출 후 return count
*/