import java.util.*;
import java.io.*;

public class Main2146C {

  static int N, cnt = 0;

  static int[][] area;
  static int[][] vis;
  static int[][] dist;

  static int[] dx = {-1, 0, 1, 0};
  static int[] dy = {0, 1, 0, -1};

  public static void markIsland() {
    vis = new int[N][N];
    Queue<int[]> q = new LinkedList<>();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (area[i][j] == 0 || vis[i][j] == 1) continue;
        cnt++; // 섬 번호
        area[i][j] = cnt;
        vis[i][j] = 1;
        q.offer(new int[]{i, j});
        while (!q.isEmpty()) {
          int[] tmp = q.poll();
          int x = tmp[0];
          int y = tmp[1];
          for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            if (area[nx][ny] != 0 && vis[nx][ny] == 0) {
              area[nx][ny] = cnt;
              vis[nx][ny] = 1;
              q.offer(new int[]{nx, ny});
            }
          }
        }
      }
    }
  }

  public static void initDistArr() {
    for (int i = 0; i < N; i++) {
      Arrays.fill(dist[i], -1);
    }
  }

  public static int findShortestPath() {
    int ans = 999999;

    dist = new int[N][N]; //해당 부분까지의 거리 저장 배열
    initDistArr();

    Queue<int[]> q = new LinkedList<>();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (area[i][j] == 0) continue;
        dist[i][j] += 1;
        q.offer(new int[]{i, j});
        boolean find = false;
        while (!q.isEmpty() && !find) {
          int[] tmp = q.poll();
          int x = tmp[0]; int y = tmp[1];
          for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            if (dist[nx][ny] >= 0 || area[nx][ny] == area[i][j]) continue; // 여기 주의 !!!
            // 다른 육지에 다다랐을 때
            if (area[nx][ny] != 0 && area[nx][ny] != area[i][j]) {
              find = true;
              ans = Math.min(ans, dist[x][y]);
              while (!q.isEmpty()) q.poll();
              break;
            }
            // 다른 육지에 다다르지 못했을 때
            dist[nx][ny] = dist[x][y] + 1;
            q.offer(new int[]{nx, ny});
          }
        }
        initDistArr();
      }
    }
    
    return ans;
  }

  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    area = new int[N][N];

    for (int i = 0; i < N; i++) {
      String[] tmp = br.readLine().split(" ");
      for (int j = 0; j < tmp.length; j++) {
        area[i][j] = Integer.parseInt(tmp[j]);
      }
    }

    markIsland(); // 육지 구별해서 표시하기
    System.out.println(findShortestPath()); // 최소 경로 구하기
  }
}