//정수의 각 자리수 접근
//StringBuilder 사용
//뒤에서부터 3자리 씩 카운트해서 , 추가하기

import java.util.Scanner;

public class Main6A {

    public static StringBuilder solution(int N) {
        StringBuilder sb = new StringBuilder(); //결과값 저장
        String str = String.valueOf(N);
        int cnt = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (cnt == 3) {
                cnt = 0;
                sb.append(',');
            }
            sb.append(str.charAt(i));
            cnt += 1;
        }
        return sb.reverse();
    }

    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        int N = kbd.nextInt();
        System.out.println(solution(N));
    }
}