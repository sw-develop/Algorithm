//소수 세기
//소수 - 1과 자기자신만 약수로 가지는 수
//1은 소수가 아님

//방식1 - 2 ~ (해당 숫자 - 1)까지 확인 - O(N^2)
//방식2 - 2 ~ 해당 숫자의 제곱근까지 확인 - O(NlogN)
//N의 약수는 N의 제곱근 범위 내에 존재함
//방식3 - 아리스토네체 사용 - O(N^2)

import java.util.*;

public class Main4A {

    public static int solution(int n) { // O(N^2)
        int cnt = n - 1; //1 제외
        for (int i = 3; i <= n; i++) {
            for (int j = 2; j <= i - 1; j++)
                if (i % j == 0) {
                    cnt -= 1;
                    break;
                }
        }
        return cnt;
    }

    public static int solB(int n) { // O(NlogN)
        int cnt = n - 1; //1 제외
        for (int i = 3; i <= n; i++) {
            for (int j = 2; j <= Math.sqrt(i); j++) // O(NlogN)
                if (i % j == 0) { //소수가 아님
                    cnt -= 1;
                    break;
                }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        int n = kbd.nextInt();
        System.out.println(solB(n));
    }
}