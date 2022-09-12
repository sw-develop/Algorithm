import java.util.*;

public class Main4A {

  public static int solution(int N, int[] input) {
    int answer = 1;

    int[] dy = new int[N];
    dy[0] = 1;
    for (int i = 1; i < N; i++) {
      int max = 0;
      for (int j = i - 1; j >= 0; j--) {
        if (input[j] < input[i] && dy[j] > max) {
          max = dy[j];
        }
      }
      dy[i] = max + 1;
      answer = Math.max(answer, dy[i]);
    }

    return answer;
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    int N = kbd.nextInt();
    int[] input = new int[N];
    for (int i = 0; i < N; i++) {
      input[i] = kbd.nextInt();
    }
    System.out.println(solution(N, input));
  }
}