//4M

import java.util.*;

public class Main4A {

  public static int[] solution(int N) {
    int[] output = new int[N];
    output[0] = 1; output[1] = 1;
    for (int i = 2; i < N; i++) {
      output[i] = output[i-2] + output[i-1];
    }
    return output;
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    int N = kbd.nextInt();
    for(int i : solution(N)) {
      System.out.print(i + " ");
    }
  }
}