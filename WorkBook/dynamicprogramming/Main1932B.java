import java.util.*;
import java.io.*;

public class Main1932B {

  static int[][] input = new int[505][505];
  static int[][] sum = new int[505][505];

  public static void solution(int n) { // 1~n까지로 확인
    sum[1][1] = input[1][1];

    for (int i = 2; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        sum[i][j] = Math.max(sum[i - 1][j - 1], sum[i - 1][j]) + input[i][j];
      }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st;
    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= i; j++) {
        input[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    solution(n);
    Arrays.sort(sum[n], 1, n + 1); // 오름차순 정렬
    System.out.println(sum[n][n]);
  }
}