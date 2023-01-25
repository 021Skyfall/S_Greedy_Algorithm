package Regular_Expression;

import java.util.regex.Pattern;

public class Email_isValid {
    public static void main(String[] args) {
        isValid("xxx@vxcode.com","\\w+@\\w+\\.\\w+(\\.\\w+)?");
        isValid("xxxvxcodecom","\\w+@\\w+\\.\\w+(\\.\\w+)?");
    }
    private static void isValid(String email, String regExp) {
        if (Pattern.matches(regExp,email)) System.out.println("올바른 이메일 형식입니다.");
        else System.out.println("이메일 형식이 아닙니다.");
    }
}
