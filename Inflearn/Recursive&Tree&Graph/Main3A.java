import java.util.*;

public class Main3A {

  public static int recursive(int N) {
    if (N == 1)
      return 1;
    else
      return N * recursive(N - 1);
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    int N = kbd.nextInt();
    System.out.println(recursive(N));
  }
}