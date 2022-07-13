//17M

import java.util.*;

public class Main9A {

  public static int solution(int N, int[][] input) {
    int output = Integer.MIN_VALUE;
    
    int tmp = 0;
    //행
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        tmp += input[i][j];
      }
      if (tmp > output) output = tmp;
      tmp = 0;
    }
    
    //열
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        tmp += input[j][i];
      }
      if (tmp > output) output = tmp;
      tmp = 0;
    }

    //대각선
    for (int i = 0, j = 0; i < N; i++, j++) {
      tmp += input[i][j];
    }
    if (tmp > output) output = tmp;
    tmp = 0;

    for (int i = N-1, j = 0; i >= 0; i--, j++) {
      tmp += input[i][j];
    }
    if (tmp > output) output = tmp;

    return output;
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    int N = kbd.nextInt();
    int[][] input = new int[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        input[i][j] = kbd.nextInt();
      }
    }
    System.out.println(solution(N, input));
  }
}