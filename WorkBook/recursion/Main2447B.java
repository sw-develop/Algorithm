import java.util.Arrays;
import java.io.*;

public class Main2447B {

  static char[][] board;

  public static void solution(int n, int x, int y) {
    // 재귀 종료
    if (n == 1) {
      board[x][y] = '*';
      return;
    }
    // 재귀 수행
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (i == 1 && j == 1)
          continue;
        solution(n / 3, x + n / 3 * i, y + n / 3 * j);
      }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    board = new char[N][N];
    for (int i = 0; i < N; i++) {
      Arrays.fill(board[i], ' '); // 공백으로 초기화
    }

    solution(N, 0, 0);
    for (int i = 0; i < N; i++) {
      System.out.println(board[i]);
    }
  }
}

/* 문제 회고

<풀이>
2차원 배열을 공백문자로 초기화 해두고, 재귀를 통해서 *이 찍히는 곳만 *을 찍어줌
-> 배열을 공백문자로 우선 초기화 해두면, 공백문자여야 하는 부분에 대해서는 재귀를 수행하지 않게 됨

<놓쳤던 부분>
*이 찍히는 부분과 공백문자가 찍히는 부분을 나누어서 찍으려고 했고, 공백 문자를 찍는 범위 계산을 잘못함

*/