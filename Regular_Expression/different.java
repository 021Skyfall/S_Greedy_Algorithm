package Regular_Expression;

import java.util.regex.Pattern;

public class different {
    // 길이가 5 또는 7이고 0~9 까지의 숫자만 있는지 boolean 타입으로 return
    public static void main(String[] args) {
        System.out.println(solution("aasdw"));
        System.out.println(solution("21111"));
        System.out.println(solution2("2424swd"));
    }
    // 정규표현식 사용
    private static boolean solution(String str) {
        String regExp = "\\d{5}$|\\d{7}$";
        return Pattern.matches(regExp,str);
    }
    // 정규표현식 미사용
    private static boolean solution2(String str) {
        if (str.length() == 5 || str.length() == 7) {
            for (int i = 0; i < str.length(); i++) {
                if (!Character.isDigit(str.charAt(i))) return false;
            }
            return true;
        }
        return false;
    }
}
