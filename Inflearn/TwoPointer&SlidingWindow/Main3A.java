//19M

import java.util.*;

public class Main3A {
  
  public static int solution(int N, int K, int[] input) {
    int output = 0, tmp = 0;
    for (int i = 0; i < K; i++) tmp += input[i];
    output = tmp;
    for (int i = K; i < N; i++) {
      tmp = tmp - input[i-K] + input[i];
      output = Math.max(output, tmp);
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