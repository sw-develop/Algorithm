import java.util.*;

public class Main2A {

  public static int[] solution(int N, int[] input) {
    for (int i = N-1; i > 0; i--) {
      for (int j = 0; j < i; j++) {
        if (input[j] > input[j+1]) {
          int tmp = input[j];
          input[j] = input[j+1];
          input[j+1] = tmp;
        }
      }
    }
    return input;
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    int N = kbd.nextInt();
    int[] input = new int[N];
    for (int i = 0; i < N; i++) input[i] = kbd.nextInt();
    for (int i : solution(N, input)) 
      System.out.print(i + " ");
  }
}