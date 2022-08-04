//for + 메모이제이션

import java.util.*;

public class Main4D {

  public static long[] result = new long[100];

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    int N = kbd.nextInt();
    for (int i = 1; i <= N; i++) {
      if (i == 1 || i == 2) {
        result[i] = 1;
        System.out.print(1 + " ");
      } else {
        result[i] = result[i - 2] + result[i - 1];
        System.out.print(result[i] + " ");
      }
    }
  }
}