package Math_Algorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class Combination {
    public static void main(String[] args) {
        System.out.println(cLoop(new String[]{"A", "B", "C", "D", "E"}));
        System.out.println(count(new String[]{"A", "B", "C", "D", "E"}));
    }
    private static ArrayList<String> cLoop(String[] deck) {
        // 순열로 구할 수 있는 경우를 찾고서
        // 중복된 경우의 수를 나눔
        // 즉 순열은 카드가 무한할 때 조합 할 수 있는 최대의 조합을 순서대로 나열한 거고
        // 조합은 각 카드가 단 하나만 있을 경우 뽑을 수 있는 최대의 조합임
        // 일반식: nCr = n! / (r! * (n - r)!)
        // 5C3 = 5! / (3! * 2!) = 10

        ArrayList<String> result = new ArrayList<>();

        // 이전에 뽑은 카드의 다음 꺼를 뽑아줘야하기 때문에 +1 붙여서 다음 반복문에서는 다음 요소 탐색
        // 그래서 따로 조건문이 필요하지 않음
        for (int i = 0; i < deck.length; i++) {
            for (int j = i + 1; j < deck.length; j++) {
                for (int k = j + 1; k < deck.length; k++) {
                    String[] input = new String[]{deck[i],deck[j],deck[k]};
                    result.add(Arrays.toString(input));
                }
            }
        }
        return result;
    }
    // 마찬가지로 개수 체크용
    private static int count(String[] deck) {
        ArrayList<String> result = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < deck.length; i++) {
            for (int j = i + 1; j < deck.length; j++) {
                for (int k = j + 1; k < deck.length; k++) {
                    String[] input = new String[]{deck[i],deck[j],deck[k]};
                    result.add(Arrays.toString(input));
                    count++;
                }
            }
        }
        return count;
    }
}
