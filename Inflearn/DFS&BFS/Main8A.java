import java.util.*;

public class Main8A {

  static int N, F;
  static int[] p, b, ch;
  static int[][] memo;
  static boolean flag = false;

  public static int combi(int n, int r) { // 조합수 구하는 함수
    if (r == 0 || n == r)
      return 1;
    if (memo[n][r] != 0)
      return memo[n][r];
    return combi(n - 1, r - 1) + combi(n - 1, r);
  }

  public static void dfs(int cnt, int sum) { // 순열 구하는 함수
    if (flag)
      return;
    if (cnt == N) { // 순열이 완성됐을 때
      if (sum == F) {
        flag = true;
        for (int i : p)
          System.out.print(i + " ");
        return;
      }
    }
    for (int i = 1; i <= N; i++) {
      if (ch[i] == 0) {
        ch[i] = 1;
        p[cnt] = i;
        dfs(cnt + 1, sum + p[cnt] * b[cnt]);
        ch[i] = 0;
      }
    }
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    N = kbd.nextInt();
    F = kbd.nextInt();
    p = new int[N]; // 순열 저장 배열
    b = new int[N]; // 조합수 저장 배열
    ch = new int[N + 1];

    memo = new int[N + 1][N + 1];
    for (int i = 0; i < N; i++) {
      b[i] = combi(N - 1, i);
    }

    dfs(0, 0);
  }
}
