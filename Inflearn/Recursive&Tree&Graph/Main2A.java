import java.util.*;

public class Main2A {

  public static void recursive(int N) {
    if (N != 0) {
      recursive(N / 2);
      System.out.print(N % 2);
    }
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    int N = kbd.nextInt();
    recursive(N);
  }
}