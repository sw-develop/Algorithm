import java.util.*;

public class Main10A {

  static int[][] board = new int[7][7];
  static int min = 1000;
  static int[] dx = { -1, 1, 0, 0 };
  static int[] dy = { 0, 0, -1, 1 };

  public static void dfs(int x, int y, int cnt) {
    if (cnt >= min)
      return;
    if (x == board.length - 1 && y == board.length - 1) {
      min = Math.min(min, cnt);
      return;
    }
    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      if (0 <= nx && nx < board.length && 0 <= ny && ny < board.length) {
        if (board[nx][ny] == 0) {
          board[nx][ny] = 1;
          dfs(nx, ny, cnt + 1);
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
    dfs(0, 0, 0);

    if (min == 1000)
      System.out.println(-1);
    else
      System.out.println(min);
  }
}