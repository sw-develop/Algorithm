import java.util.*;
import java.io.*;

public class Main1B {

  static int[][] fibo = new int[41][2];

  public static void fibo() {
    fibo[0][0] = 1;
    fibo[1][1] = 1;
    for (int i = 2; i <= 40; i++) {
      fibo[i][0] = fibo[i - 1][0] + fibo[i - 2][0];
      fibo[i][1] = fibo[i - 1][1] + fibo[i - 2][1];
    }
  }

  public static void main(String[] args) throws Exception {
    fibo();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      int idx = Integer.parseInt(br.readLine());
      sb.append(fibo[idx][0]).append(' ').append(fibo[idx][1]).append('\n');
    }
    System.out.println(sb);
  }
}

/* 문제회고

수정내용
- 2차원 배열 사용

풀이과정
1. 문제에 필요한 변수 파악
2. 변수 간 관계식 만들기 - DP 값 정의 & 점화식 도출
3. 초기값 설정하기

*/