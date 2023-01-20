package Greedy_Algorithm.Coplit;

public class c_BoardGame {
    public static void main(String[] args) {
        int[][] board1 = new int[][]{
                {0, 0, 0, 1},
                {1, 1, 1, 0},
                {1, 1, 0, 0},
                {0, 0, 0, 0}
        };
        System.out.println(boardGame(board1,"RRDLLD"));
    }
    public static Integer boardGame(int[][] board, String operation) {
        // U = 상 / D = 하 / L = 좌 / R = 우
        // 표에서 해당하는 문자열을 입력하면
        // 상화좌우로 이동하면서 1을 획득함
        // 입력값 = 문자열 / 출력 : 마지막에 도달했을 때의 획득한 숫자 총합 or 범위를 벗어나면 null
        // 시작 기준점은 board[0][0]
        // R = 현재 인덱스의 다음 인덱스
        // L = 현재 인덱스의 이전 인덱스
        // U = 현재 인덱스가 위치한 바깥 배열 인덱스의 다음 인덱스의 이전 인덱스가 위치한 인덱스
        // D = 현재 인덱스가 위치한 바깥 배열 인덱스의 이전 인덱스의 현재 인덱스가 위치한 인덱스

//        // 시작 지점 설정
//        int start = board[0][0];
//        // 시작 지점에서 L 혹은 U 으로 이동이면 무조건 null 임
//        if (operation.startsWith("U") || operation.startsWith("L")) return null;
//        // 커맨드 저장
//        String command = "";
//        // 커맨드 입력을 위해 문자에서 캐릭터 하나씩 뽑아주기
//        for (int i = 1; i <= operation.length(); i++) {
//            command = String.valueOf(operation.charAt(i));
//            // 뽑은 캐릭터 별로 행동 입력
//            if (command.equals("R")) {
//                start = board[0][i];
//            } else if (command.equals("D")) {
//                start = board[i][0];
//            }
//        }
        // 이런 접근은 결국 i가 늘어 날때 마다 start 가 두칸씩, 세칸씩 이동하는 문제점이 있다
        // 그렇다고 전부 다 따로 for 문을 돌리려니 결국 마찬가지 일거고
        // 이동 커맨드를 먼저 깔끔하게 정의하고 들어가면 좋을거같은데
        // 특별히 생각나는게 없네
        // R = board[?][++] / L = board[?][--] / U = board[--][?] / D = board[++][?]
        // 이런식으로 접근하면 될 거 같은데...
        // ? -> 이 부분을 어떻게 채우지

        // 점수 저장할 변수
        int score = 0;
        // x좌표 저장할 변수
        int x = 0;
        // y좌표 저장할 변수
        int y = 0;

        // 앞서 했던 것과 마찬가지로 결국 문자열에서 문자를 하나씩 뽑아야함
        for (int i = 0; i < operation.length(); i++) {
            // 각 문자가 나왔을 때 좌표 설정 (축을 배열 인덱스에 대입해서 생각하면)
            // U 면 x 축이 0 , y 축이 -1
            if (operation.charAt(i) == 'U') {x += 0; y -= 1;}
            // D 이면 x 축이 0, y축이 +1
            else if (operation.charAt(i) == 'D') {x += 0; y += 1;}
            // R 면 x 축이 +1, y 축이 0
            else if (operation.charAt(i) == 'R') {x += 1; y += 0;}
            // L 면 x 축이 -1, y축이 0
            else if (operation.charAt(i) == 'L') {x -= 1; y += 0;}

            // 범위 벗어났을 경우 null 리턴
            // 조건은 각 인덱스가 음수일 때 혹은 보드의 크기를 벗어났을 때
            if (x < 0 || x > board.length || y < 0 || y > board.length) return null;

            // 이외에는 해당 좌표를 가지고 다 더해주면됨
            // 왜? 0 아니면 1 이니까
            score += board[y][x];
        }
        return score;
    }
}
// 흐름
/*
* "RRDLLD" 가정
* score 0 x 0 y 0
* for
* if -> R = x 1 y 0
* score += board[0][1] = 0
* score = 0
* for
* if -> R = x 2 y 0
* score += board[0][1] = 0
* score = 0
* for
* if -> D = x 2 y 1
* score += board[1][2] = 1
* score = 1
* for
* if -> L = x 1 y 1
* score += board[1][1] = 1
* score = 2
* for
* if -> L = x 0 y 1
* score += board[1][0] = 1
* score = 3
* for
* if -> D = x 0 y 2
* score += board[0][2] = 1
* score = 4
* 종료 후 return score
 */
