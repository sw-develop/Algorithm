import java.util.*;
import java.io.*;

public class Main2146B {

  static int N, cnt = 0;
  static int area[][];
  static int vis[][];
  static int dist[][];

  static int[] dx = { -1, 0, 1, 0 };
  static int[] dy = { 0, 1, 0, -1 };

  public static void markIsland() { // 함수1
    // 서로 다른 육지 표시
    // cnt : 섬 번호, area[i][j] 값이 같은 경우 같은 섬임
    Queue<int[]> q = new LinkedList<>();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (area[i][j] == 0 || vis[i][j] == 1) continue;
        cnt++;
        vis[i][j] = 1;
        area[i][j] = cnt;
        q.offer(new int[]{i, j});
        while (!q.isEmpty()) {
          int[] tmp = q.poll();
          int x = tmp[0];
          int y = tmp[1];
          for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            if (vis[nx][ny] == 1 || area[nx][ny] == 0) continue;
            area[nx][ny] = cnt;
            vis[nx][ny] = 1;
            q.offer(new int[]{nx, ny});
          }
        }
      }
    }
  }

  public static void initializeDistArr() {
    for (int i = 0; i < N; i++) {
      Arrays.fill(dist[i], -1);
    }
  }

  public static int findShortestPath() { // 함수2 
    initializeDistArr();

    int ans = 999999;
    // 모든 육지 (i, j) 각각에 대해 bfs 진행
    // 이때 area[i][j] != area[nx][ny]인 최초의 (nx, ny)를 찾으면 (i, j)에서 시작하는 다리의 길이 계산 가능
    Queue<int[]> q = new LinkedList<>();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (area[i][j] != 0) {
          q.offer(new int[] { i, j });
          dist[i][j] = 0;
          boolean escape = false; // 다리를 찾으면 이 변수를 true로 만들어 bfs 중단
          while (!q.isEmpty() && !escape) {
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];
            for (int dir = 0; dir < 4; dir++) {
              int nx = x + dx[dir];
              int ny = y + dy[dir];
              if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
              if (dist[nx][ny] >= 0 || area[i][j] == area[nx][ny]) continue;
              if (area[nx][ny] != 0 && area[i][j] != area[nx][ny]) {
                ans = Math.min(ans, dist[x][y]);
                while (!q.isEmpty()) q.poll();
                escape = true;
                break;
              }
              dist[nx][ny] = dist[x][y] + 1;
              q.offer(new int[] { nx, ny });
            }
          }
          initializeDistArr();
        }
      }
    }

    return ans;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    area = new int[N][N];
    vis = new int[N][N];
    dist = new int[N][N];

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

/* 문제 회고

구성
함수1) 섬 구분해서 표시하기
함수2) 서로 다른 두 섬의 최소 거리 찾기

바킹독은 어떻게 풀었을까?! 이런 문제는 어떻게 사고해야할까?!
전체적인 문제 해결을 위한 구성은 바킹독과 일치함

*/