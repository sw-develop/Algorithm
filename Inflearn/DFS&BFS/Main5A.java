import java.util.*;

public class Main5A {

  static int N, M;
  static Integer[] input;
  static int answer = Integer.MAX_VALUE;

  public static void dfs(int cnt, int total) {
    if (total == M) {
      answer = Math.min(answer, cnt);
    }
    if (cnt > answer) return;
    if (total < M) {
      for (int i = 0; i < N; i++) {
        dfs(cnt + 1, total + input[i]);
      }
    }
  }
  
  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    N = kbd.nextInt();
    input = new Integer[N];
    for (int i = 0; i < N; i++)
      input[i] = kbd.nextInt();
    Arrays.sort(input, Collections.reverseOrder());
    M = kbd.nextInt();
    dfs(0, 0);
    System.out.println(answer);
  }
}