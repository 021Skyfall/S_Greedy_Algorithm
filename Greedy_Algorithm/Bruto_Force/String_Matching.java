package Greedy_Algorithm.Bruto_Force;

public class String_Matching {
    public static void main(String[] args) {
        String[] str = new String[]{"A","B","C","D","E","F"};
        String[] pattern = new String[]{"E","F"};
        System.out.println(Smatch(str,pattern));

    }
    private static boolean Smatch (String[] str, String[] pattern) {
        // 전체 배열 길이에서 패턴 배열 길이를 뺀 만큼만 반복 / 단 마지막꺼 까지 비교해야되서 <=
        for (int i = 0; i <= str.length - pattern.length; i++) {
            // 패턴과 비교위치를 잡아출 j 선언 0 할당
            int j = 0;
            // j 가 패턴의 개수보다 커지면 안되니까 개수만큼만 반복
            // 조건은 패턴 배열의 j 인덱스 요소가 전체 배열의 i+j 인덱스 요소와 같은지
            while (j < pattern.length && pattern[j].equals(str[i+j]))  {
                j += 1; // 같다면 +1
            }
            // 패턴의 길이와 j 가 같아지면 true 리턴
            if (j == pattern.length) return true;
        }
        return false;
    }
}