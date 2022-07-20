import java.util.*;

public class Main5A {

  public static int solution(int N) {
    int output = 0, sum = 0, lt = 1;

    for (int rt = 1; rt < N; rt++) {
      sum += rt;
      if (sum == N) output++;
      while (sum >= N) {
        sum -= lt;
        lt++;
        if (sum == N) output++;
      }
    }

    return output;
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    int N = kbd.nextInt();
    System.out.println(solution(N));
  }
}