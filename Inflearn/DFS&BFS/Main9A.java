import java.util.*;

public class Main9A {

  static int[][] board = new int[7][7];
  static int result = 0;
  static int[] dx = { -1, 1, 0, 0 }; // 상하좌우
  static int[] dy = { 0, 0, -1, 1 };

  public static void dfs(int x, int y) {
    if (x == (board.length - 1) && y == (board.length - 1)) {
      result++;
      return;
    }
    for (int i = 0; i < dx.length; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      if (0 <= nx && nx < board.length && 0 <= ny && ny < board.length) {
        if (board[nx][ny] == 0) {
          board[nx][ny] = 1;
          dfs(nx, ny);
          board[nx][ny] = 0;
        }
      }
    }
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    for (int i = 0; i < 7; i++) {
      for (int j = 0; j < 7; j++) {
        board[i][j] = kbd.nextInt();
      }
    }
    board[0][0] = 1;
    dfs(0, 0);
    System.out.println(result);
  }
}