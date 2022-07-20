import java.util.*;

public class Main4A {

  public static int solution(int N, int M, int[] input) {
    int output = 0, sum = 0, lt = 0;

    for (int rt = 0; rt < N; rt++) {
      sum += input[rt];
      if (sum == M) output++;
      while (sum >= M) {
        sum -= input[lt++];
        if (sum == M) output++;
      }
    }
  
    return output;
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    int N = kbd.nextInt();
    int M = kbd.nextInt();
    int[] input = new int[N];
    for (int i = 0; i < N; i++) {
      input[i] = kbd.nextInt();
    }
    System.out.println(solution(N, M, input));
  }
}