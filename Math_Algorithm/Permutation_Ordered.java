package Math_Algorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutation_Ordered {
    public static void main(String[] args) {
        // 순서를 생각한 순열의 모든 경우의 수

        System.out.println(pLoop(new String[]{"A", "B", "C", "D", "E"}));
        System.out.println(much(new String[]{"A", "B", "C", "D", "E"}));
    }
    private static ArrayList<String> pLoop(String[] deck) {
        ArrayList<String> result = new ArrayList<>();
//        for (int i = 0; i < deck.length; i++) {
//            for (int j = 0; j < deck.length; j++) {
//                for (int k = 0; k < deck.length; k++) {
//                    if (i == j || j == k || k == i) continue;
//                    String[] input = new String[]{deck[i],deck[j],deck[k]};
//                    result.add(Arrays.toString(input));
//                }
//            }
//        }
        // 위를 풀어서
        for (int i = 0; i < deck.length; i++) {
            String pick1 = deck[i];
            for (int j = 0; j < deck.length; j++) {
                String pick2 = deck[j];
                for (int k = 0; k < deck.length; k++) {
                    String pick3 = deck[k];

                    if (i == j || j == k || k == i) continue; // AAA EEE 등의 중복 제거
                    result.add(Arrays.toString(new String[]{pick1,pick2,pick3}));
                }
            }
        }
        return result;
    }
    private static int much(String[] deck) {
        ArrayList<String> result = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < deck.length; i++) {
            for (int j = 0; j < deck.length; j++) {
                for (int k = 0; k < deck.length; k++) {
                    if (i == j || j == k || k == i) continue;
                    String[] input = new String[]{deck[i],deck[j],deck[k]};
                    result.add(Arrays.toString(input));
                    count++;
                }
            }
        }
        return count;
    }
}
