//29M

import java.util.*;

public class Main11A {
  
  public static int solution(int N, int[][] input) {
    int output = 0;
    int[][] check = new int[N][N]; //같은 반이었던 학생 체크 배열
    for (int i = 0; i < N; i++) { //행
      for (int j = 0; j < 5; j++) { //열
        int target = input[i][j];
        for (int k = 0; k < N; k++) {
          if (check[i][k] != 0) continue; //이미 같은 반 확인
          if (target == input[k][j]) {
            check[i][k] = 1;
          }
        }
      }
    }
    //가장 같은 반이었던 학생이 많은 학생 추출
    int max = Integer.MIN_VALUE; //주의!!
    for (int i = 0; i < N; i++) {
      int result = 0;
      for (int j = 0; j < N; j++) {
        result += check[i][j];
      }
      if (result > max) {
        max = result;
        output = i + 1;
      }
    }

    return output;
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    int N = kbd.nextInt();
    int[][] input = new int[N][5];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < 5; j++) {
        input[i][j] = kbd.nextInt();
      }
    }
    System.out.println(solution(N, input));
  }
}