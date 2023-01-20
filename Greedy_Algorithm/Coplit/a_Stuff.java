package Greedy_Algorithm.Coplit;

//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.Queue;

//public class a_Stuff {
//    public static void main(String[] args) {
//        System.out.println(movingStuff(new int[]{60, 80, 120, 90, 130}, 140));
//    }
//
//    public static int movingStuff(int[] stuff, int limit) {
//        // stuff 배열의 요소는 각각 무게를 나타냄
//        // limit 은 한번 옮길 때 최대 무기 제한
//        // * 최대 두 개까지 한 번에 옮길 수 있음
//        // 해당 문제는 stuff 를 전부 옮기려면 몇 번이 되는지 묻고있음
//
//        // 큐 프린터 문제랑 비슷하게 접근해봄
//        // 박스의 크기 지정 후 안에 0을 채워넣음 ~> 무게 별로 들어올 수 있는지 없는지 판단
//        Queue<Integer> box = new LinkedList<>();
//        // 찾아내기 쉽도록 정렬
//        Arrays.sort(stuff);
//        for (int i = 0; i < 2; i++) {
//            box.add(0);
//        }
//        // 횟수 할당할 변수 선언
//        int count = 0;
//        //전체 배열이 빌때까지 반복 ~> 물건을 전부 옮겼을 때
//        while (stuff.length != 0) {
//            // 맨 처음 작업 입력
//            // stuff 의 각 요소를 순회하고
//            for (int i = 0; i < stuff.length; i++) {
//                // 해당 요소가 limit 보다 작으면 들어가야함
//                // 아 큐 안 요소랑 배열 요소 합쳤을 때도 limit 넘기면 안됨 이게 젤 중요한데 왜..
//                if (box.stream().reduce(0,Integer::sum) + stuff[i] <= limit) {
//                    box.poll();
//                    box.add(stuff[i]);
//                    // 아 반복 계속 돌아가는게 stuff 에서 요소 안빼줬구나
//                    stuff = Arrays.copyOfRange(stuff,1,stuff.length);
//                } else if (box.stream().reduce(0, Integer::sum) <= limit) {
//                    box.poll();
//                    box.poll();
//                    count++;
//                    // 이후 박스에 0을 다시 채워 넣음
//                    for (int j = 0; j < 2; j++) {
//                        box.add(0);
//                    }
//            }
//            // 박스에 배열의 요소가 위에서 걸러진게 담긴다면 합이 0이 아닐 것이고
//            // 1~2개를 전부 빼내고 횟수 1번 +
//            }
//        }
//        return count;
//        // 어 왜 반복이 계속되지 ㅋㅋㅋ
//    }
//}
//stuff 60 80 90 120 130
//box 0 0
//count 0
//
//while
//
//for
//if 60 < limit ? true
//box 0 null;
//box 0 60
//stuff 80 90 120 130
//
//for
//box 합 60+80 (=140) && 80 <= 140 ? true
//box 60 80
//stuff 90 120 130
//
//for
//box 합 60 + 80 + 90 <= 140 ? false
//else ~> 배열 비움 탈출
//
//if
//140 != 0? true box 0 0 count 1
// ...
//while 탈출 왜? ~> 이전 포문에서 배열 비워버려서 ~> 여기서 배열 다시 채워주면 될듯

// 흠... 로직은 맞는 거 같고 흐름도 쭉 해봤을 때 나와야하는데 왜 안되지
// 이거 내가 한 방법은 앞에서 부터 순서대로 세어 나가기 때문인거 같음 이게 맞는듯
// 테스트 결과값이 두 번 다 count 가 높은거 보니까
// 앞이랑 뒤랑, 앞이랑 뒤랑 이런식으로 비교해서 넣어줘서
// 순서가 섞여 있을 때 문제되는 거 같음
// 이거 해결하려고 배열 정렬하긴 했는데
// 정렬 해봤자
// 0번 인덱스랑 4번 인덱스랑 합치면 들어갈 수 있는데
// 그런 경우를 포함시키지 못하고 무조건 0,1 부터 조합되기 때문에 생기는 문제인듯
// 이런...

import java.util.Arrays;

// 아래부터 다시
public class a_Stuff {
    public static void main(String[] args) {
        System.out.println(movingStuff(new int[]{60, 80, 120, 90, 130}, 140));
    }
    public static int movingStuff(int[] stuff, int limit) {
        // 이진 탐색 DQ를 위한 배열 요소 정렬
        Arrays.sort(stuff);
        // 중간 위치
        int box = 0;
        // 최소 위치
        int min = 0;
        // 최대 위치
        int max = stuff.length-1;
        // 최소가 최대를 넘을 때까지
        while (min < max) {
            // 만약 최소위치 인덱스의 요소 + 최대위치 인덱스의 요소 가 <= limit 이면
            // 두개를 한꺼번에 옮길 수 있는 상황
            if (stuff[min] + stuff[max] <= limit) {
                // 해당 상황이면 제일 처음 요소와 제일 마지막 요소의 다음 인덱스 요소를 찾아야함
                min++;
                max--;
                // 하나를 옮겼으니 box 에 1을 더해줌
                box++;
            } else { // 위에 해당하지 않는다면 우선적으로 가장 높은 요소부터 옮겨져야함
                // 우선적으로 가장 높은 요소부터 옮겨져야함
                max--;
            }
        }
        // 전체 요소 중 if에 걸린 요소를 빼주면 총 박스 개수임
        return stuff.length-box;
    }
}
// 흐름
// {60, 80, 90, 120, 130}
// box 0 min 0 max 4
// while 0 < 4 true
// if 60 + 130 <= 140 false
// else max 3
// while 0 < 3 true
// if 60 + 120 <= 140 false
// else max 2
// while 0 < 2 true
// if 60 + 90 <= false
// else max 1
// while 0 < 1 true
// if 60 + 80 <= true
// min 1 max 0 box 1
// while 1 < 0 false

// return 5 - 1
// 길이에 빼주는 이유는
// 요소 2개 한꺼번에 옮긴 상황 = 해당 요소 합쳐서 한 번 이랑 같다 봐야하니까