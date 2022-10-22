//문자열 reverse

//문자열 끝에서부터 접근
//charArray 변환 후 for문으로 앞, 뒤 인덱스 교환

import java.util.*;

public class Main3A {

    public static StringBuilder solution(String str) {
        StringBuilder output = new StringBuilder();
        char[] arr = str.toCharArray();
        for (int i = arr.length - 1; i >= 0; i--) {
            output.append(arr[i]);
        }
        return output;
    }

    public static String solB(String str) {
        char[] arr = str.toCharArray();
        for (int i = 0; i < str.length() / 2; i++) {
            char tmp = arr[i];
            arr[i] = arr[str.length() - 1 - i];
            arr[str.length() - 1 - i] = tmp;
        }
        return String.valueOf(arr);
    }

    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);

        String input = kbd.nextLine();
        System.out.println(solB(input));
    }
}