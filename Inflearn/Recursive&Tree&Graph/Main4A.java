import java.util.*;

public class Main4A {

  public static int[] arr = new int[46];

  public static void recursive(int N) {
    if (N > 2) {
      recursive(N - 1);
      arr[N] = arr[N - 1] + arr[N - 2];
      System.out.print(arr[N] + " ");
    } else if (1 <= N && N <= 2) {
      recursive(N - 1);
      arr[N] = 1;
      System.out.print(arr[N] + " ");
    }
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    int N = kbd.nextInt();
    recursive(N);
  }
}