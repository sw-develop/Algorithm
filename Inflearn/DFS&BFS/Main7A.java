import java.util.*;

public class Main7A {

  public static int[][] memo;

  public static int dfs(int n, int r) {
    if (r == 0 || n == r)
      return 1;
    if (memo[n][r] != 0)
      return memo[n][r];
    memo[n][r] = dfs(n - 1, r - 1) + dfs(n - 1, r);
    return memo[n][r];
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    int n = kbd.nextInt();
    int r = kbd.nextInt();
    memo = new int[n + 1][n + 1];
    System.out.println(dfs(n, r));
  }
}