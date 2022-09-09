import java.util.*;

public class Main1A {

  static int N, answer = 0;

  public static void dfs(int sum) {
    if (sum == N) {
      answer++;
      return;
    }
    if (sum > N)
      return;
    dfs(sum + 1);
    dfs(sum + 2);
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    N = kbd.nextInt();
    dfs(0);
    System.out.println(answer);
  }
}