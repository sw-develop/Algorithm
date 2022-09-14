import java.util.*;

class Quiz {
  int s, t;

  public Quiz(int s, int t) {
    this.s = s;
    this.t = t;
  }
}

public class Main7A {

  public static int solution(int N, int M, List<Quiz> input) {
    int[] dp = new int[M+1];

    for (int i = 0; i < N; i++) {
      for (int j = M; j >= input.get(i).t; j--) {
        dp[j] = Math.max(dp[j], dp[j - input.get(i).t] + input.get(i).s);
      }
    }

    return dp[M];
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    int N = kbd.nextInt();
    int M = kbd.nextInt();

    List<Quiz> input = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      input.add(new Quiz(kbd.nextInt(), kbd.nextInt()));
    }
    
    System.out.println(solution(N, M, input));
  }
}