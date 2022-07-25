import java.util.*;

public class Main5B {

  public static int solution(int N, int K, int[] input) {
    TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
    for (int i = 0; i < N - 2; i++) {
      for (int j = i + 1; j < N - 1; j++) {
        for (int g = j + 1; g < N; g++) {
          set.add(input[i] + input[j] + input[g]);
        }
      }
    }
    int order = 0;
    for (int i : set) {
      order++;
      if (order == K) return i;
    }
    return -1;
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