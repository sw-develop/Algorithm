//BOJ 1003

import java.util.*;
import java.io.*;

public class Main1A {

  static int[] cntA = new int[41]; // 0 출력 횟수 저장
  static int[] cntB = new int[41]; // 1 출력 횟수 저장

  public static void solution() {
    cntA[0] = 1;
    cntB[1] = 1;
    for (int i = 2; i <= 40; i++) {
      cntA[i] = cntA[i - 1] + cntA[i - 2];
      cntB[i] = cntB[i - 1] + cntB[i - 2];
    }
  }

  public static void main(String[] args) throws Exception {
    solution();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      int idx = Integer.parseInt(br.readLine());
      sb.append(cntA[idx]).append(' ').append(cntB[idx]).append('\n');
    }
    System.out.println(sb);
  }
}

/* 문제회고

풀이과정
- 점화식 정의
- N까지의 0 출력 횟수, 1 출력 횟수 구한 뒤 배열로 접근

*/