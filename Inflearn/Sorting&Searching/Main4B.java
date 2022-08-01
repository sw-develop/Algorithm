import java.util.*;

public class Main4B {

  public static int[] solution(int S, int N, int[] input) {
    int[] output = new int[S];
    for (int e : input) {
      int pos = -1;
      for (int i = 0; i < S; i++) {
        if (output[i] == e) {
          pos = i;
          break;
        }
      }
      if (pos == -1) { //cache miss
        for (int i = S - 1; i >= 1; i--)
          output[i] = output[i - 1];
      } else { //cache hit
        for (int i = pos; i >= 1; i--)
          output[i] = output[i - 1];
      }
      output[0] = e;
    }
    return output;
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    int S = kbd.nextInt();
    int N = kbd.nextInt();
    int[] input = new int[N];
    for (int i = 0; i < N; i++)
      input[i] = kbd.nextInt();
    for (int i : solution(S, N, input))
      System.out.print(i + " ");
  }
}