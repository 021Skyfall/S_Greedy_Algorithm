package Math_Algorithm.Coplit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class b_Chicken {
    public static void main(String[] args) {

    }
    private ArrayList<Integer[]> newChickenRecipe(int[] stuffArr, int choiceNum) {
        // 0과 1로만 이루어진 수열
        // 항상 1로 시작
        // 0이 3개 이상이면 제외
        // 배열 : 중복 X, 길이는 20 이하, 배열은 2~10
        // 정수 : 1~ 배열 길이 이하의 자연수 , 재료를 선택할 수 있는 수를 뜻함
        // ex) stuffArr 가 [1, 10, 11000, 1111] 이고,
        // choiceNum 은 2라면 사용 가능한 재료는 [1, 10, 1111]
        // 조합할 수 있는 경우의 수는 6 가지
        // 주어진 재료가 모두 0이 3개 이상이면 return null
        // arr 이 num 보다 작으면 return null
        // 작은 수 -> 큰 수로 정렬

        // 사용가능한 요소만 담을 리스트 생성
        ArrayList<Integer> use = new ArrayList<>();

        // 배열 순회하며 사용 가능한 요소 만 리스트에 추가
        for (int i = 0; i < stuffArr.length; i++) {
            // 각 요소를 String 타입으로 바꾼 뒤
            String str = String.valueOf(stuffArr[i]);
            // int 타입의 배열에 0이 들어간 요소 추가
            // 각 요소를 char 타입의 배열로 바꾼 뒤 스트림 -> .chars()
            int[] e = str.chars().filter(c -> c == '0').toArray();
            // 만약 0 이 2개 이하라면 use 리스트에 추가
            if (e.length <= 2) {
                use.add(stuffArr[i]);
            }
        }

        // 사용 가능한 요소를 담을 리스트를 오름차순 정렬
        Collections.sort(use);

        // 다 거르고서 사용할 수 있는 요소가 없거나, 배열 길이보다 넘버가 크면 null 리턴
        if (use.size() == 0 || use.size() < choiceNum) return null;

        // 결과를 담을 리스트 선언
        ArrayList<Integer[]> result = new ArrayList<>();

        // 해당 재료의 사용 여부를 확인할 배열 ~> BFS
        boolean[] visit = new boolean[use.size()];

        // 재귀 호출로 모든 경우의 수를 구하고 해당 값을 리턴
        return p(choiceNum,new Integer[]{}, result, use, visit, 0);
    }
    // (사용할 재료, 값을 옮기기 위한 일회용 배열, 결과, 사용가능한 재료들, 방문 여부, 사용한 재료 수)
    private ArrayList<Integer[]> p(int choiceNum, Integer[] bucket, ArrayList<Integer[]> result, ArrayList<Integer> use, boolean[] visit, int depth) {
        // 사용한 재료 숫자가 사용할 재료 숫자에 도달하면 재귀종료
        if (depth == choiceNum) {
            // 담았던 재료가 저장된 배열을 결과 리스트에 넣어주고
            result.add(bucket);
            // 해당 리스트 리턴
            return result;
        }

        // 사용 가능한 재료 만큼 반복
        for (int i = 0; i < use.size(); i++) {
            // 해당 재료를 사용하지 않았다면
            if (!visit[i]) {
                // 사용했다고 체크해주고
                visit[i] = true;
                // bucket 에 해당 재료 삽입 ~> 재귀 돌면서 이어 붙여줘야하기 때문에 새로운 배열 생성
                Integer[] concat = Arrays.copyOf(bucket,bucket.length+1);
                // 계속 크기 한칸 씩 늘려주면서 다음 인덱스에 사용한 재료 삽입
                // 마찬가지로 clone 으로 깊은 복사 가능
                concat[concat.length-1] = use.get(i);

                // 재귀 호출
                // 사용한 재료 수를 하나씩 늘려주면서 실행
                // bucket 은 해당 배열에 담겼던 재료들을 복사한 concat 으로 가져감
                result = p(choiceNum,concat,result,use,visit,depth+1);
                // 재귀 순회 이후 반복문을 다시 시작하기 위해 첫 시작 재료 방문여부 false로 바꿈
                visit[i] = false;
            }
        }
        return result;
    }
}
