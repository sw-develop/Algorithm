import java.util.*;

public class Main1A {

  public static int[] solution(int N, int[] input) {
    for (int i = 0; i < N - 1; i++) {
      int idx = i;
      for (int j = i + 1; j < N; j++) {
        if (input[j] < input[idx]) {
          idx = j;
        }
      }
      int tmp = input[i];
      input[i] = input[idx];
      input[idx] = tmp;
    }
    return input;
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    int N = kbd.nextInt();
    int[] input = new int[N];
    for (int i = 0; i < N; i++) {
      input[i] = kbd.nextInt();
    }
    for (int i : solution(N, input)) {
      System.out.print(i + " ");
    }
  }
}