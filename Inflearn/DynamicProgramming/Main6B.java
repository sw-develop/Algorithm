import java.util.*;

public class Main6B {

  static int N, M;
  static int[] coins; // 동전의 종류

  static int INF = (int) 1e9;

  public static int solution() {
    // DP 테이블 초기화 
    int[] dy = new int[M + 1];
    Arrays.fill(dy, INF);

    // DP 진행 (bottom-up)
    dy[0] = 0;
    for (int i = 0; i < N; i++) { // 동전의 종류 개수 기준
      for (int j = coins[i]; j <= M; j++) {
        if (dy[j - coins[i]] != INF) {
          dy[j] = Math.min(dy[j], dy[j - coins[i]] + 1);
        }
      }
    }

    if (dy[M] == INF) return 0;
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