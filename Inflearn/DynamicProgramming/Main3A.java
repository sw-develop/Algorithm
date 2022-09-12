import java.util.*;

public class Main3A {

  public static int solution(int N) {
    int[] dy = new int[N + 2];
    dy[1] = 1;
    dy[2] = 2;
    for (int i = 3; i <= N + 1; i++) {
      dy[i] = dy[i-2] + dy[i-1];
    }
    return dy[N + 1];
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    int N = kbd.nextInt();
    System.out.println(solution(N));
  }
}