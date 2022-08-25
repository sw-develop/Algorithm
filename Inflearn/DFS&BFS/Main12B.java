import java.util.*;

class Point {
  int x;
  int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

public class Main12B {

  static int[][] board;
  static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
  static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };

  public static void dfs(int x, int y, int N) {
    for (int i = 0; i < dx.length; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      if (0 <= nx && nx < N && 0 <= ny && ny < N && board[nx][ny] == 1) {
        board[nx][ny] = 0;
        dfs(nx, ny, N);
      }
    }
  }
  
  public static int solution(int N) {
    int output = 0;

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (board[i][j] == 1) {
          board[i][j] = 0;
          dfs(i, j, N);
          output++;
        }
      }
    }

    return output;
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    int N = kbd.nextInt();
    board = new int[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        board[i][j] = kbd.nextInt();
      }
    }
    System.out.println(solution(N));
  }
}