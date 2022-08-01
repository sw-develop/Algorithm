import java.util.*;

public class Main4A {

  public static Deque<Integer> solution(int S, int N, int[] input) {
    Deque<Integer> output = new LinkedList<>();
    for (int i : input) {
      if (output.contains(i)) {
        output.remove(i);
        output.addFirst(i);
      } else {
        if (output.size() != S)
          output.addFirst(i);
        else {
          output.removeLast();
          output.addFirst(i);
        }
      }
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