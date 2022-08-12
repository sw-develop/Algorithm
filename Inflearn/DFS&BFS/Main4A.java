import java.util.*;

public class Main4A {

  static int N, M;

  public static void dfs(int num, int cnt) {
    if (cnt == M) {
      System.out.println(num);
      return;
    }
    for (int i = 1; i <= N; i++) {
      System.out.print(num + " ");
      dfs(i, cnt + 1);
    }
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    N = kbd.nextInt();
    M = kbd.nextInt();
    for (int i = 1; i <= N; i++)
      dfs(i, 1);
  }
}