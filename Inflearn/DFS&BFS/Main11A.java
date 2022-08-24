import java.util.*;

class Point {
  int x;
  int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

public class Main11A {

  static int M, N;
  static int[][] box;
  static int cntA = 0; // 익은 토마토 개수 
  static int cntB = 0; // 안익은 토마토 개수
  static int[] dx = { -1, 1, 0, 0 };
  static int[] dy = { 0, 0, -1, 1 };

  public static int solution() {
    Queue<Point> q = new LinkedList<>();

    for (int i = 0; i < N; i++) { //초기 세팅
      for (int j = 0; j < M; j++) {
        if (box[i][j] == 0)
          cntB++;
        else if (box[i][j] == 1)
          q.offer(new Point(i, j));
      }
    }

    if (cntB == 0)
      return 0;

    int day = 0;
    while (cntB > 0 && !q.isEmpty()) {
      int len = q.size();
      day++;
      for (int i = 0; i < len; i++) {
        Point p = q.poll();
        for (int j = 0; j < 4; j++) {
          int nx = p.x + dx[j];
          int ny = p.y + dy[j];
          if (0 <= nx && nx < N && 0 <= ny && ny < M && box[nx][ny] == 0) {
            box[nx][ny] = 1;
            cntB--;
            q.offer(new Point(nx, ny));
          }
        }
      }
    }

    if (cntB > 0)
      return -1;
    return day;
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    M = kbd.nextInt(); //열
    N = kbd.nextInt(); //행
    box = new int[N][M];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        box[i][j] = kbd.nextInt();
      }
    }
    System.out.println(solution());
  }
}