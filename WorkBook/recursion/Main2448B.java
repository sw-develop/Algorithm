import java.io.*;

public class Main2448B {

  static char[][] board;

  public static void fillStar(int x, int y) {
    board[x][y] = '*';
    board[x+1][y-1] = '*'; board[x+1][y+1] = '*';
    for (int i = y - 2; i <= y + 2; i++) {
      board[x+2][i] = '*';
    }
  }

  public static void solution(int l, int x, int y) {
    // 재귀 종료
    if (l == 3) {
      fillStar(x, y);
      return;
    }
    // 재귀 수행
    int nl = l / 2;
    solution(nl, x, y);
    solution(nl, x + nl, y - nl);
    solution(nl, x + nl, y + nl);
  }
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    board = new char[N][2*N-1];
    solution(N, 0, N-1);

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < 2*N - 1; j++) {
        if (board[i][j] == '*') sb.append('*');
        else sb.append(' ');
      }
      sb.append('\n');
    }
    System.out.println(sb);
  }
}