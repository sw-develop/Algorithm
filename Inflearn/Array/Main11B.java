import java.util.*;

public class Main11B {

  public static int GRADE = 6;
  
  public static int solution(int N, int[][] input) {
    int output = 0, max = Integer.MIN_VALUE;

    for (int i = 1; i < N+1; i++) {
      int cnt = 0; //같은 반이었던 학생 수
      for (int j = 1; j < N+1; j++) {
        for (int k = 1; k < GRADE; k++) {
          if (input[i][k] == input[j][k]) {
            cnt++;
            break;
          }
        }
      }
      if (cnt > max) {
        max = cnt;
        output = i;
      }
    }

    return output;
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    int N = kbd.nextInt();
    int[][] input = new int[N+1][GRADE];
    for (int i = 1; i < N+1; i++) {
      for (int j = 1; j < GRADE; j++) {
        input[i][j] = kbd.nextInt();
      }
    }
    System.out.println(solution(N, input));
  }
}