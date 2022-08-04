// 일반 재귀

import java.util.*;

public class Main4B {

  public static int recursive(int N) {
    if (N == 1 || N == 2)
      return 1;
    else
      return recursive(N - 2) + recursive(N - 1);
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    int N = kbd.nextInt();
    for (int i = 1; i <= N; i++)
      System.out.print(recursive(i) + " ");
  }
}