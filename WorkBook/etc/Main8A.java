//문자열에서 각 문자 접근
//if '_' then 그 다음 문자 대문자로 변환해 저장

//대소문자 변환 - String과 Character 클래스의 toUpperCase(), toLowerCase()

import java.util.Scanner;

public class Main8A {

    public static StringBuilder solution(String str) {
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '_' && i != str.length()-1) {
                ans.append(Character.toUpperCase(str.charAt(i+1)));
                i += 1;
            } else {
                ans.append(str.charAt(i));
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        String input = kbd.nextLine();
        kbd.close();

        System.out.println(solution(input));
    }

}