import java.util.*;

public class Main5A {

  public static int solution(int N) {
    int output = 0;
    int[] check = new int[N+1];
    for (int i = 2; i <= N; i++) {
      if (check[i] == 0) {
        output++;
        for (int j = i; j <= N; j += i) check[j] = 1;
      }
    }
    return output;
  }
  
  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    int N = kbd.nextInt();
    System.out.println(solution(N));
  }
}