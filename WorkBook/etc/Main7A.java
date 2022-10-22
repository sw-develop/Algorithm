//문자열 한 문자씩 접근해서 x 이면 제외 (맨 앞, 맨 뒤인 경우 예외)
//StringBuilder 저장

import java.util.*;

public class Main7A {

    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        String input = kbd.nextLine();
        kbd.close();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length() ; i++) {
            if (i == 0 || i == input.length()-1) sb.append(input.charAt(i));
            else {
                if (input.charAt(i) != 'x') sb.append(input.charAt(i));
            }
        }

        System.out.println(sb);
    }
}