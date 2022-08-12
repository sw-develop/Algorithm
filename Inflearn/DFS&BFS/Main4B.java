import java.util.*;

public class Main4B {

  static int N, M;
  static int[] output;

  public static void dfs(int cnt) { // cnt: 횟수
    if (cnt == M) {
      for (int i : output)
        System.out.print(i + " ");
      System.out.println();
      return;
    }
    for (int i = 1; i <= N; i++) {
      output[cnt] = i;
      dfs(cnt + 1);
    }
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    N = kbd.nextInt();
    M = kbd.nextInt();
    output = new int[M];
    dfs(0);
  }
}