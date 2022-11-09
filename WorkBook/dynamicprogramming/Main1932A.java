//BOJ 1932

//합이 최대가 되는 경로에 있는 수의 합 -> 모든 경우의 수 탐색
//재귀
//DP 적용

//특정 위치의 합 = 이전까지 수의 합 최대 + 현재 위치의 값

import java.util.*;
import java.io.*;

public class Main1932A {

  static int[][] input;
  static int[][] sum;

  public static void solution(int n) {
    sum[0][0] = input[0][0];

    if (n == 1)
      return;

    sum[1][0] = sum[0][0] + input[1][0];
    sum[1][1] = sum[0][0] + input[1][1];
    for (int i = 3; i <= n; i++) {
      sum[i - 1][0] = sum[i - 2][0] + input[i - 1][0];
      sum[i - 1][i - 1] = sum[i - 2][i - 2] + input[i - 1][i - 1];
      for (int j = 1; j <= i - 2; j++) {
        sum[i - 1][j] = Math.max(sum[i - 2][j - 1], sum[i - 2][j]) + input[i - 1][j];
      }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    input = new int[n][n];
    StringTokenizer st;
    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < i; j++) {
        input[i - 1][j] = Integer.parseInt(st.nextToken());
      }
    }

    sum = new int[n][n];
    solution(n);
    Arrays.sort(sum[n - 1]); // 오름차순 정렬
    System.out.println(sum[n - 1][n - 1]);
  }
}