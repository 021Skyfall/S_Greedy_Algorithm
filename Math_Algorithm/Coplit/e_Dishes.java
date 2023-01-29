package Math_Algorithm.Coplit;

import java.util.*;
import java.util.stream.Collectors;

public class e_Dishes {
    public static void main(String[] args) {
        ArrayList<String[]> result = missHouseMeal(new String[] {"eggroll", "kimchi", "fishSoup"});
        List<String> output = new ArrayList<>();
        for (String[] s : result) {
            output.add(Arrays.toString(s));
        }
        System.out.println(output);
        // 구글링하니까 대부분 이런식으로 변환하게끔하네
        // 출력은 원하는대로 정확히 나오는데
        // 이거보다 더 간편한 방법 없나
    }
    private static ArrayList<String[]> missHouseMeal(String[] sideDishes) {
        // 멱집합 문제
        // 멱집합?
        // ex)
        // B={1,2}
        // B의 부분집합은 0,{1},{2},{1,2}
        // P(B)={0,{1},{2},{1,2}}
        // = 2^B

        // search 함수에 사용할 빈 스택 선언
        Stack<String> stack = new Stack<>();

        // 결과를 담을 ArrayList 선언
        ArrayList<String[]> result = new ArrayList<>();

        // 배열 요소를 오름차순으로 정렬
        Arrays.sort(sideDishes);

        // 빈 스택과 0 번 째 인덱스(Depth), 정렬된 재료로 구성된 배열, 결과를 담을 List 를 인자로 받는 재귀 함수 실행
        result = search(stack,0,sideDishes,result);

        // 결과를 오름차순으로 정렬
        // 배열 요소를 스트링으로 형변환 후 Comparator 인터페이스의 comparing 메소드 오버라이드
        result.sort(Comparator.comparing(Arrays::toString));

        return result;
    }
    private static ArrayList<String[]> search(Stack<String> stack,int index , String[] sideDishes, ArrayList<String[]> result) {
        // Base Case
        // 만약 인덱스와 배열의 길이가 같아지면 스택을 배열로 변환 후에 해당 스택을 result 리스트에 삽입
        // 단, 마지막까지 검토한 경우여야함
        if (sideDishes.length == index) {
            String[] arr = stack.toArray(new String[0]);
            result.add(arr);
            return result;
        } else {
            // 인덱스가 부분집합에 포함된 경우
            // 값을 넣어주고 인덱스을 늘려 재귀 호출
            stack.push(sideDishes[index]);
            search(stack,index+1,sideDishes,result);

            // 인덱스가 부분집합에 포함되지 않은 경우
            // 값을 빼주고 인덱스를 늘려 재귀 호출
            stack.pop();
            search(stack,index+1,sideDishes,result);
            // 결국 인덱스는 기본적으로 늘어나게끔 되어 있어서
            // 요소를 push & pop 하면서 멱집합 구하기
        }
        return result;
    }
}
// 뭔가 어렵다싶으면 풀이가 결국 재귀함수로 돌아가네
/* 흐름
* 간편하게 {e, k, f} 로 배열 변경
* stack []
* result []
* sort {e, f, k}
*
* result = search([],0,{e, f, k},[])
* if 3 == 0 ? false
* else
* stack = [e]
* search([e],1,{e, f, k},[])
*
* if 3 == 1 ? false
* else
* stack = [e, f]
* search([e, f],2,{e,f,k},[])
*
* if 3 == 2 ? false
* else
* stack = [e,f,k]
* search(e,f,k,3,{e,f,k},[])
*
* if 3 == 3 ? true
* result = [[e,f,k]]
* return
*
* stack = [e,f]
* search([e,f],3,{e,f,k},[[e,f,k]])
*
* ... 반복 되면서 아래로 흐르고 result 로 리턴
* ! push 와 pop 을 이용한 멱집합 구현 <- 이게 제일 중요
 */