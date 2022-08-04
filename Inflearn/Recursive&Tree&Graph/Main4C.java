//재귀 + 메모이제이션

import java.util.*;

public class Main4C {

  public static long[] result = new long[100];

  public static long fibo(int N) {
    if (N == 1 || N == 2)
      return 1;
    if (result[N] != 0) // 계산한 적이 있는 값
      return result[N];
    result[N] = fibo(N - 2) + fibo(N - 1);
    return result[N];
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    int N = kbd.nextInt();
    for (int i = 1; i <= N; i++) {
      System.out.print(fibo(i) + " ");
    }
  }
}