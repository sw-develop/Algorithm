import java.util.*;

public class Main3A {

  static int N, M;
  static int answer = 0;

  public static void dfs(int idx, int sum, int time, int[][] input) {
    if (time > M) return;
    if (idx == N) {
      answer = Math.max(answer, sum);
      return;
    }
    dfs(idx + 1, sum + input[idx][0], time + input[idx][1], input);
    dfs(idx + 1, sum, time, input);
  }
  
  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    N = kbd.nextInt();
    M = kbd.nextInt();
    int[][] input = new int[N][2];
    for (int i = 0; i < N; i++) {
      input[i][0] = kbd.nextInt();
      input[i][1] = kbd.nextInt();
    }
    dfs(0, 0, 0, input);
    System.out.println(answer);
  }
}