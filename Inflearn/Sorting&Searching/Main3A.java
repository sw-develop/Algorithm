import java.util.*;

public class Main3A {

  public static int[] solution(int N, int[] input) {
    for (int i = 1; i < N; i++) {
      int key = input[i], j;
      for (j = i - 1; j >= 0 && input[j] > key; j--) {
        input[j + 1] = input[j];
      }
      input[j + 1] = key;
    }

    return input;
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    int N = kbd.nextInt();
    int[] input = new int[N];
    for (int i = 0; i < N; i++)
      input[i] = kbd.nextInt();
    for (int i : solution(N, input))
      System.out.print(i + " ");
  }
}