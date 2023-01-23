package Greedy_Algorithm.Coplit;

public class d_GTA {
    public static void main(String[] args) {
        System.out.println(ocean(50, new int[]{10, 20, 50}));
    }
    public static long ocean(int target, int[] type) {
        // 다이나믹 프로그래밍의 기초적인 문제
        // 쉽게 말해서 50원을 10원 20원 50원을 사용해서 거슬러 줄 때의 경우의 수는 몇 번이냐고 묻는 것
        // ex) 50 = 50
        // ex) 20 + 20 + 10 = 50
        // ex) 20 + 10 + 10 + 10 = 50
        // ex) 10 + 10 + 10 + 10 + 10 = 50
        // = 4번

        // 총 경우의 수를 담을 배열 선언
        // 최소한의 경우의 수는 한 가지기 때문에 0번 째 인덱스를 1 로 지정
        long[] bag = new long[target+1];
        // bag = [0,0,0,0,0,0]
        bag[0] = 1;
        // bag = [1,0,0,0,0,0]

        // 돈의 종류가 담긴 배열을 순차 탐색
        for (int i = 0; i < type.length; i++) {
            // 타겟까지 순회
            // 최소 한가지 경우의 수가 있기 때문에 해당 인덱스는 제외하고 그 다음 인덱스부터 탐색
            // target 을 포함하는 이유는 해당 동전까지 포함해서 값을 도출해야하기 때문
            for (int j = 1; j <= target; j++) {
                // bag 의 인덱스가 type[i] 보다 큰 구간만 걸러줌
                // 작은 구간은 어차피 type[i] 에 해당하는 동전으로 만들 수 없는 금액임
                if (type[i] <= j)
                    // 기존 경우의 수에 type[i]를 뺀 금액을 만들 수 있는 경우의 수를 더해줌
                    // 작은 화폐 부터 순차적으로 경우의 수 늘려감
                    // 즉 10원으로 나오는 경우의 수를 1씩 bag 에 쭉 저장하고
                    // 20원으로 나오는 경우의 수를 10원 자리 빼고 bag 에 쭉 저장하고
                    // 50원으로 나오는 경우의 수는 맨 처음 1가지와 뒤에서 합쳐나 나오는 경우의 수를 더해줌
                    // 어려움 ㄹㅇ
                    bag[j] += bag[j-type[i]];
                //정형화된 알고리즘 패턴이라니까 몇 번 더 봐보아야 할 것 같음
            }

        }
        return bag[target];
        // 위의 bag[j] += bag[j-type[i]]; 이 로직을 통해서 마주치는 가장 마지막의 인덱스가
        // 곧 전체의 결과 경우의 수
    }
}
