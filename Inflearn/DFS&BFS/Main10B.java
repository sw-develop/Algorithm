import java.util.*;

class Point {
  int x;
  int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

public class Main10B {

  static int[][] board = new int[7][7];
  static int[][] dis = new int[7][7]; // 경로 저장 배열
  static int[] dx = { -1, 1, 0, 0 };
  static int[] dy = { 0, 0, -1, 1 };

  public static void bfs(int x, int y) {
    Queue<Point> q = new LinkedList<>();
    q.offer(new Point(x, y));
    board[x][y] = 1;

    while (!q.isEmpty()) {
      Point p = q.poll();
      for (int i = 0; i < 4; i++) {
        int nx = p.x + dx[i];
        int ny = p.y + dy[i];
        if (0 <= nx && nx < 7 && 0 <= ny && ny < 7 && board[nx][ny] == 0) {
          board[nx][ny] = 1;
          q.offer(new Point(nx, ny));
          dis[nx][ny] = dis[p.x][p.y] + 1; //경로 업데이트
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
    bfs(0, 0);
    if (dis[6][6] == 0) System.out.println(-1);
    else System.out.println(dis[6][6]);
  }
}