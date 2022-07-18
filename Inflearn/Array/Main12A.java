import java.util.*;

public class Main12A {

  public static int solution(int N, int M, int[][] input) {
    int output = 0;

    for(int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        int cnt = 0;
        for (int k = 0; k < M; k++) {
          int pi = 0, pj = 0;
          for (int s = 0; s < N; s++) {
            if (input[k][s] == i) pi = s;
            if (input[k][s] == j) pj = s;
          }
          if (pi < pj) cnt++;
        }
        if (cnt == M) output++;
      }
    }
    
    return output;
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    int N = kbd.nextInt(); //학생 수 
    int M = kbd.nextInt(); //테스트 횟수
    int[][] input = new int[M][N];
    for(int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        input[i][j] = kbd.nextInt();
      }
    }
    System.out.println(solution(N, M, input));
  }
}