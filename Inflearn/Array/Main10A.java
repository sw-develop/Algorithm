//26M
//배열의 각 원소를 탐색하는 것 맞음 -> 어떻게 효율적으로 탐색할 것인가

import java.util.*;

public class Main10A {

  public static int[][] check;

  public static int[] row = {-1, 1, 0, 0}; //상하좌우
  public static int[] col = {0, 0, -1, 1};
  
  public static int solution(int N, int[][] input) {
    int output = 0;

    check = new int[N][N]; //0 = 탐색 필요, 1 = 탐색 X
    
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (check[i][j] != 0) continue;

        int target = input[i][j];
        check[i][j] = 1;
        boolean isBonguri = true;
        for (int k = 0; k < 4; k++) {
          int tmpRow = i + row[k];
          int tmpCol = j + col[k];
          if (0 <= tmpRow && tmpRow < N && 0 <= tmpCol && tmpCol < N) {
            if (input[tmpRow][tmpCol] < target) check[tmpRow][tmpCol] = 1;
            else isBonguri = false;
          }
        }
        if (isBonguri) output++;
      }
    }

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