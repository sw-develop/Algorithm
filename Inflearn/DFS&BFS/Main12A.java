import java.util.*;

class Point {
  int x;
  int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

public class Main12A {

  static int N;
  static int[][] board;
  static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 }; // 상하좌우대각선
  static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };

  public static void bfs(int x, int y, Queue<Point> q) {
    q.offer(new Point(x, y));
    while (!q.isEmpty()) {
      Point p = q.poll();
      for (int k = 0; k < dx.length; k++) {
        int nx = p.x + dx[k];
        int ny = p.y + dy[k];
        if (0 <= nx && nx < N && 0 <= ny && ny < N && board[nx][ny] == 1) {
          board[nx][ny] = 0;
          q.offer(new Point(nx, ny));
        }
      }
    }
  }

  public static int solution() {
    int output = 0;

    Queue<Point> q = new LinkedList<>();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (board[i][j] == 1) {
          board[i][j] = 0;
          bfs(i, j, q);
          output++;
        }
      }
    }

    return output;
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    N = kbd.nextInt();
    board = new int[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        board[i][j] = kbd.nextInt();
      }
    }
    System.out.println(solution());
  }
}