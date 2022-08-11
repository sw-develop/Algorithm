import java.util.*;

public class Main2A {

  static int C, N;
  static int answer = 0;

  public static void dfs(int idx, int sum, int[] arr) {
    if (sum > C)
      return;
    if (idx == N) {
      answer = Math.max(answer, sum);
      return;
    }
    dfs(idx + 1, sum + arr[idx], arr);
    dfs(idx + 1, sum, arr);
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    C = kbd.nextInt();
    N = kbd.nextInt();
    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = kbd.nextInt();
    }
    dfs(0, 0, arr);
    System.out.println(answer);
  }
}