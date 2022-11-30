import java.util.*;
import java.io.*;

public class Main1941B {

  static char[][] stu = new char[5][5];
  static int ans = 0;

  static boolean[] mask = new boolean[25];

  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};

  public static void bfs() {
    Queue<int[]> q = new LinkedList<>();

    boolean[][] isp7 = new boolean[5][5];
    boolean[][] vis = new boolean[5][5];
    for (int i = 0; i < 25; i++) {
      if (mask[i]) { // 7공주로 선택되었음
        int x = i / 5, y = i % 5;
        isp7[x][y] = true;
        if (q.isEmpty()) {
          q.offer(new int[]{x, y});
          vis[x][y] = true;
        }
      }
    }

    int dasom = 0, adj = 0;
    while (!q.isEmpty()) {
      int[] tmp = q.poll();
      int x = tmp[0], y = tmp[1];
      adj++;
      if (stu[x][y] == 'S') dasom++;
      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || vis[nx][ny] || !isp7[nx][ny])
          continue;
        q.offer(new int[]{nx, ny});
        vis[nx][ny] = true;
      }
    }

    if (adj >= 7 && dasom >= 4)
      ans++;
  }

  public static void solution(int k, int idx) {
    // 재귀 종료
    if (k == 7) {
      bfs();
      return;
    }
    // 재귀 수행
    for (int i = idx; i < 25; i++) {
      mask[i] = true;
      solution(k + 1, i + 1);
      mask[i] = false;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
    for (int i = 0; i < 5; i++) {
      String str = br.readLine();
      for (int j = 0; j < 5; j++) {
        stu[i][j] = str.charAt(j);
      }
    }

    solution(0, 0);
    System.out.println(ans);
  }
}