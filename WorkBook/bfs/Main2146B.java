import java.util.*;
import java.io.*;

public class Main2146B {

  static int N;
  static int area[][];

  static int[] dx = { -1, 0, 1, 0 };
  static int[] dy = { 0, 1, 0, -1 };

  static int marking = 2;

  public static void markIsland() {
    // 서로 다른 육지 표시

    Queue<int[]> q = new LinkedList<>();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (area[i][j] != 1)
          continue;
        if (area[i][j] == 1) {
          q.offer(new int[] { i, j });
          area[i][j] = marking;
        }
        while (!q.isEmpty()) {
          int[] tmp = q.poll();
          int cx = tmp[0];
          int cy = tmp[1];
          for (int k = 0; k < 4; k++) {
            int nx = cx + dx[k];
            int ny = cy + dy[k];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N)
              continue;
            if (area[nx][ny] == 1) {
              q.offer(new int[] { nx, ny });
              area[nx][ny] = marking;
            }
          }
        }
        marking += 1;
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        System.out.print(area[i][j] + " ");
      }
      System.out.println();
    }
    
  }

  public static int findShortestPath() {
    // 모든 육지 (i, j) 각각에 대해 bfs 진행
    // 이때 area[i][j] != area[nx][ny]인 최초의 (nx, ny)를 찾으면 (i, j)에서 시작하는 다리의 길이 계산 가능

    int ans = 100;

    int[][] dist = new int[N][N];

    for (int i = 0; i < N; i++) {
      Arrays.fill(dist[i], -1);
    }

    Queue<int[]> q = new LinkedList<>();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (area[i][j] != 0) {
          q.offer(new int[] { i, j });
          dist[i][j] = 0;
          boolean escape = false;
          while (!q.isEmpty() && !escape) {
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];
            for (int dir = 0; dir < 4; dir++) {
              int nx = x + dx[dir];
              int ny = y + dy[dir];
              if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                continue;
              if (dist[nx][ny] >= 0 || area[i][j] == area[nx][ny])
                continue;
              if (area[nx][ny] != 0 && area[i][j] != area[nx][ny]) {
                ans = Math.min(ans, dist[nx][ny]);
                while (!q.isEmpty())
                  q.poll();
                escape = true;
                break;
              }
              dist[nx][ny] = dist[x][y] + 1;
              q.offer(new int[] { nx, ny });
            }
          }
          for (int k = 0; k < N; k++) {
            Arrays.fill(dist[k], -1);
          }
        }
      }
    }

    return ans;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    area = new int[N][N];

    for (int i = 0; i < N; i++) {
      String[] str = br.readLine().split(" ");
      for (int j = 0; j < N; j++) {
        area[i][j] = Integer.parseInt(str[j]);
      }
    }

    markIsland();
    System.out.println(findShortestPath());
  }
}