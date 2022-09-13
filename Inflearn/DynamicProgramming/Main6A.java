import java.util.*;

public class Main6A {

  static int N, M;
  static int[] coins; // 동전의 종류

  static int INF = (int) 1e9;

  public static int solution() {
    int[] dy = new int[M + 1];

    // 직관적인 값 초기화
    for (int i : coins) {
      dy[i] = 1;
    }

    // DP 진행 (bottom-up)
    for (int i = 1; i <= M; i++) {
      if (dy[i] == 0) {
        int min = INF;
        for (int j : coins) {
          if (i - j > 0 && dy[i - j] != 0) {
            min = Math.min(min, dy[i - j]);
          }
        }
        if (min != INF)
          dy[i] = min + 1;
      }
    }

    return dy[M];
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    N = kbd.nextInt();
    coins = new int[N];
    for (int i = 0; i < N; i++) {
      coins[i] = kbd.nextInt();
    }
    M = kbd.nextInt();
    System.out.println(solution());
  }
}