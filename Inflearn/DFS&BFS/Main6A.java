import java.util.*;

public class Main6A {

  static int N, M;
  static int[] input;
  static int[] output;
  static int[] ch;

  public static void dfs(int idx) {
    if (idx == M) {
      for (int i : output) {
        System.out.print(i + " ");
      }
      System.out.println();
      return;
    }
    for (int i = 0; i < N; i++) {
      if (ch[i] == 0) {
        ch[i] = 1;
        output[idx] = input[i];
        dfs(idx + 1);
        ch[i] = 0;
      }
    }
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    N = kbd.nextInt();
    M = kbd.nextInt();
    input = new int[N];
    for (int i = 0; i < N; i++) {
      input[i] = kbd.nextInt();
    }
    output = new int[M];
    ch = new int[N];
    dfs(0);
  }
}