import java.util.*;

public class Main6A {

  public static int solution(int N, int K, int[] input) {
    int output = 0, cnt = 0, lt = 0;
    for (int rt = 0; rt < N; rt++) {
      if (input[rt] == 0) cnt++;
      while (cnt > K) {
        if (input[lt] == 0) cnt--;
        lt++;
      }
      output = Math.max(output, rt-lt+1);
    }
    return output;
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    int N = kbd.nextInt();
    int K = kbd.nextInt();
    int[] input = new int[N];
    for (int i = 0; i < N; i++) {
      input[i] = kbd.nextInt();
    }
    System.out.println(solution(N, K, input));
  }
}