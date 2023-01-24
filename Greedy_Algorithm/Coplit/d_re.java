package Greedy_Algorithm.Coplit;

public class d_re {
    public static void main(String[] args) {
        System.out.println(ocean(5, new int[]{1, 2, 5}));
    }
    private static long ocean(int target, int[] type) {
        // 간단하게 이 문제는 target 을 type 배열에 담긴 요소들로 나누어 떨어질때
        // 그 때가 몇번이냐고 보면됨
        // 경우의 수를 담을 배열
        // 크기는 입력 받은 정수의 +1 만큼 ~> 마찬가지 0부터 시작이니까
        long[] bag = new long[target+1];
        // 경우의 수를 역순으로 담을 것
        // 그럼 0번째는 50을 50으로 만드는 수는 1개
        bag[0] = 1;

        // 배열을 순차적으로 탐색하면서 배열의 각 요소가 50이 되려할 때 몇 번의 경우의 수가 나오는지 체크
        // 우선 각 배열 요소를 순회
        for (int i = 0; i < type.length; i++) {
            // 각 배열 요소를 갖고 target 만큼 순회
            for (int j = 1; j <= target; j++) {
                if (type[i] <= j) {
                    bag[j] += bag[j-type[i]];
                }
            }
        }
        return bag[target];
    }
}
// 일단 바로 이해가 어려워서 흐름부터 작성함
// 또한 예제의 값을 5, new int[]{1, 2, 5} 로 easy 하게 바꿈
/* 흐름
* bog = [0,0,0,0,0,0]
* bag = [1,0,0,0,0,0]
* out for 3회 0
* in for 5회 1
* i = 0
* j = 1
* if (1 <= 1) true
* bag[1] + bag[0]
* bag = [1,1,0,0,0,0]
*
* in for 2
* i = 0
* j = 2
* if (1 <= 2) true
* bag[2] + bag[2-1]
* bag = [1,1,1,0,0,0]
*
* in for 3
* i = 0
* j = 3
* if (1 <= 3) true
* bag[3] + bag[3-1]
* bog = [1,1,1,1,0,0]
*
* in for 4
* i = 0
* j = 4
* if (1 <= 4) true
* bag[4] + bag[4-1]
* bag = [1,1,1,1,1,0]
*
* if for 5
* i = 0
* j = 5
* if (1 <= 5) true
* bag[5] + bag[5-1]
* bag = [1,1,1,1,1,1]
*
* 여기까지의 뜻은 5를 1로 가르는 건
* 0번 인덱스 빼고 5가지라는 의미
*
* out for 1
* in for 1
* i = 1
* j = 1
* if (2 <= 1) false
*
* i = 1
* j = 2
* if (2 <= 2) true
* bog[2] + bag[2-2]
* bag = [1,1,2,1,1,1]
*
* i = 1
* j = 3
* if (2 <= 3) true
* bog[3] + bag[3-2]
* bag = [1,1,2,2,1,1]
*
* i = 1
* j = 4
* if (2 <= 4) true
* bog[4] + bag[4-2]
* bag = [1,1,2,2,3,1]
* 반복 후
* bag = [1,1,2,2,3,3]
*
* i = 2
* j = 5
* if (5 <= 5) true
* bag[5] + bag[5-5]
* bag = [1,1,2,2,3,4]
*
* 마지막으로 bag의 가장 마지막 요소 그러니까 입력된 target 인덱스를 가지는 요소를 리턴하면
* 총 횟수
 */
// 이게 흐름으로 쭉 해보니까 결국 횟수를 저장하는건 맞는데
// 쭉 반복하면서 약간 중첩 저장하는 느낌
// 선언한 횟수 배열의 마지막으로 갈 수록 횟수가 중첩됨
// 맨 처음에 0번째 인덱스에 1을 넣어준 이유는 사실
// 횟수가 무조건 하나는 나오기 때문에
// 라는게 이해하기 좀 어려울 수 있고
// 걍 1회씩 카운트++ 하기 위함 이라고 생각하는게 더 편한듯
// 진짜 걍 말그대로 경우의 수를 일일히 저장하는 거임