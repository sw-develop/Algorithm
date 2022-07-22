//41M

import java.util.*;

public class Main3A {

  public static ArrayList<Integer> solution(int N, int K, int[] input) {
    ArrayList<Integer> output = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < K; i++) { //시작 Window
      map.put(input[i], map.getOrDefault(input[i], 0) + 1);
    }
    output.add(map.size());

    for (int i = K; i < N; i++) {
      map.put(input[i - K], map.get(input[i - K]) - 1);
      if (map.get(input[i-K]) == 0)
        map.remove(input[i - K]);
      map.put(input[i], map.getOrDefault(input[i], 0) + 1);
      output.add(map.size());
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
    for (int i : solution(N, K, input)) {
      System.out.print(i + " ");
    }
  }
}