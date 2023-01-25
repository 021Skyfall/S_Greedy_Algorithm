package Math_Algorithm.Coplit;

public class c_BlackJack {
    public static void main(String[] args) {
        System.out.println(boringBlackjack(new int[]{2, 3, 4, 8, 13}));
//        System.out.println(isPrime1(9));
    }

    private static int boringBlackjack(int[] cards) {
        //1. 숫자로 이루어진 카드를 여러 장 받습니다.
        //2. 3장씩 카드를 고르고, 3장에 적힌 숫자들의 합이 소수인지 확인합니다.
        //3. 받아든 카드로 만들 수 있는 소수의 개수가 많은 사람이 이기게 됩니다.
        // 중복된 숫자의 카드는 들어있지 않으니 조합임

        // 개수 담을 변수
        int count = 0;
        // 카드 한장씩 3장까지 뽑기 반복
        for (int i = 0; i < cards.length; i++) {
            for (int j = i + 1; j < cards.length; j++) {
                for (int k = j + 1; k < cards.length; k++) {

                    // 뽑은 카드의 합
                    int num = cards[i] + cards[j] + cards[k];

//                    // 만약 뽑은 카드의 모든 수의 합이 2 보다 작으면 소수가 아님
//                    if (num < 2) {}
//                    // 만약 뽑은 카드의 모든 수의 합이 2면 소수임
//                    else if (num == 2) {count++;}
//
//                    // 최소 소수인 2부터 반복 시작해서 모든 카드의 합까지 반복
//                    for (int a = 2; a < num; a++) {
//                    //만약 뽑은 카드의 모든 수의 합까지 나누어 떨어지지 않으면 소수임
//                    if (num % a != 0) {count++;}
//                    }
                    // 이 로직이 안되서 소수 구하는 로직을 다른 메소드에 구현하겠음
                    // 보니까 위의 로직에서 반복문 부분이 꼬였음 왜 안될까
                    // 아 나누어 떨어지지 않을 때마다 count 가 올라가서 그렇구나 ㅋㅋ
                    if (isPrime(num)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
// 따로 떼서 boolean 타입으로 리턴
    private static boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
//    private static int isPrime1(int num1) {
//        int count = 0;
//        for (int i = 2; i < num1; i++) {
//            if (num1 % i != 0) {
//                count++;
//            }
//        }
//        return count;
//    }
//}
