package Math_Algorithm.Coplit;

import java.util.ArrayList;
import java.util.Arrays;

public class a_rockPaperScissors {
    public static void main(String[] args) {

    }
    private static ArrayList<String[]> rockPaperScissors(int rounds) {
        // 가위 바위 보 도중 round 만큼 회차 진행 시 나올 수 있는 모든 경우의 수
        // 두 명 이상의 플레이어, 한 사람당 3번까지 입력 가능
        // 바위 보 가위 순으로 정렬
        // 중복이 가능하니까 중복순열

        // 결과를 담을 리스트
        ArrayList<String[]> result = new ArrayList<>();
        // 재귀 호출
        return p(rounds,new String[]{},result);

    }
    // 재귀로 매판 마다 돌림
    private static ArrayList<String[]> p(int rounds, String[] play, ArrayList<String[]> out) {
        // base case / 판수가 0이 될때까지 돌림
        // 이후 0에 도달하면
        if (rounds == 0) {
            out.add(play);
            return out;
        }
        // 3가지 가중치
        String[] rps = new String[]{"rock","paper","scissors"};
        // 가중치 만큼 반복 ~> 3회
        for (int i = 0; i < rps.length; i++) {
            // 반복 횟수에 해당하는 인덱스 요소 뽑아옴
            String cur = rps[i];
            // 반복 할 때마다 가중치 담을 배열 생성
            // 로직 실행시 이전 배열을 복사 + 길이를 한 칸 늘려줌
            // 또한 이 방법은 깊은복사로 새로운 배열에 값을 담는것
            String[] concat = Arrays.copyOf(play,play.length+1);
            // 늘려준 자리에 최근에 뽑아온 rps 의 요소 추가
            concat[concat.length-1] = cur;

            // 리턴해줄 변수에 계속해서 입력됨
            // 단, 판수는 한번씩 줄이고
            out = p(rounds-1,concat,out);
        }
        return out;
    }
}
/* 흐름
* 두 명 이상의 플레이어가 rounds 만큼의 회차를 진행 했을 때
* 나올 수 있는 가위 바위 보의 총 경우의 수
* 중복순열로
* 횟수가 3회라고 가정
* 빈칸은 null
*
* result = []
*
* p(3,{},[])
* if X
* for 0~2
* for 0
* cur = rock
* concat = { , }
* concat = {rock, }
* out = p(2,{rock, },[])
*
* p(2,{rock, },[])
* if X
* for 0
* cur = rock
* concat = {rock, , }
* concat = {rock, rock, }
* out = p(1, {rock, rock, }, [])
*
* p(1, {rock, rock, }, [])
* if X
* for 0
* cur = rock
* concat = {rock, rock, , }
* concat = {rock, rock, rock, }
* out = p(0, {rock, rock, rock, }, [])
*
* if O
* out = [rock,rock,rock]
*
* 재귀 이전
* for 1
* cur = paper
* concat = {rock,rock,paper, }
* out = p(0,{rock,rock,paper, }, [rock,rock,rock])
*
* if O
* out = [[rock,rock,rock], [rock,rock,paper]]
*
* 재귀 이전
* for 2
* cur = scissors
* concat = {rock, rock, , }
* concat = {rock,rock,scissors, }
* out = p(0,{rock,rock,scissors, }, [])
*
* p(0,{rock,rock,scissors, }, [[rock,rock,rock], [rock,rock,paper]])
* if O
* out = [[rock,rock,rock], [rock,rock,paper], [rock,rock,scissors]]
*
* 재귀 이전
* for 종료
* out 리턴 -> [[rock,rock,rock], [rock,rock,paper], [rock,rock,scissors]]
*
* for 1
* cur - paper
* concat = {rock,paper, }
* out = (1,{rock,paper, }, [[rock,rock,rock], [rock,rock,paper], [rock,rock,scissors]])
*
* ...
 */
// 쉽게 말하면
// 3 판 중 모두 주먹낸 경우, 주먹 둘 보 하나, 주먹 둘 가위하나, 주먹 하나 보 둘, 주먹하나 가위 둘
// 이런 식으로 진행되는 프로세스를 타나낸 로직임