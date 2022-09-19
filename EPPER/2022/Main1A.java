import java.util.*;

public class Main1A {

  public static final int MOD = 10007;
  
  public static int solution(int N) {
    int[][] dp = new int[N+1][10];
    //초기화
    for (int i = 0; i < N+1; i++) {
      Arrays.fill(dp[i], 1);
    }
    //dp 수행
    for (int i = 2; i <= N; i++) {
      for (int j = 1; j < 10; j++) {
        dp[i][j] = dp[i][j-1] + dp[i-1][j];
        dp[i][j] %= MOD;
      }
    }
    //값 반환
    int answer = 0;
    for (int i : dp[N]) {
      answer += i;
      answer %= MOD;
    }
    return answer;
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    int N = kbd.nextInt();
    System.out.println(solution(N));
  }
}