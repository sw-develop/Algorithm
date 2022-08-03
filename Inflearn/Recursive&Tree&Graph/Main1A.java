import java.util.*;

public class Main1A {

  public static void recursive(int N) {
    if (N > 1)
      solution(N - 1);
    System.out.print(N + " ");
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    int N = kbd.nextInt();
    recursive(N);
  }
}