import java.util.Arrays;
import java.io.*;

public class Main2447C {

  static char[][] board;

  public static void solution(int N, int x, int y) {
    // 재귀 종료
    if (N == 1) {
      board[x][y] = '*';
      return;
    }
    // 재귀 수행
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (i == 1 && j == 1)
          continue;
        solution(N / 3, x + N / 3 * i, y + N / 3 * j);
      }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    board = new char[N][N];
    for (int i = 0; i < N; i++) {
      Arrays.fill(board[i], ' '); // 공백문자로 초기화
    }

    solution(N, 0, 0); // 재귀 수행해서 * 찍기

    for (int i = 0; i < N; i++) {
      System.out.println(board[i]);
    }
  }
}