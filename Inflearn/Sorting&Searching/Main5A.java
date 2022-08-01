import java.util.*;

public class Main5A {

  public static String solution(int N, int[] input) {
    Set<Integer> set = new HashSet<>();
    for (int i : input) {
      if (set.contains(i)) return "D";
      set.add(i);
    }
    return "U";
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    int N = kbd.nextInt();
    int[] input = new int[N];
    for (int i = 0; i < N; i++) {
      input[i] = kbd.nextInt();
    }
    System.out.println(solution(N, input));
  }
}