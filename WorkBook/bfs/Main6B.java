import java.util.*;
import java.io.*;

public class Main6B {

  static int[] dx = { -1, 1, 0, 0 }; // 상하좌우
  static int[] dy = { 0, 0, -1, 1 };

  static int N, M;
  static char[][] map;
  static int[][][] dist;
  //dist[x][y][0] : 벽을 하나도 부수지 않고 (x, y)까지 오는데 걸리는 비용
  //dist[x][y][1] : 벽을 하나만 부수고 (x, y)까지 오는데 걸리는 비용

  public static int solution() {
    for (int i = 0; i < N; i++) { //dist 초기화
      for (int j = 0; j < M; j++) {
        dist[i][j][0] = dist[i][j][1] = -1;
      }
    }

    dist[0][0][0] = dist[0][0][1] = 1;

    Queue<int[]> q = new LinkedList<>(); //이동 가능한 좌표 저장
    q.offer(new int[]{0,0,0});
    while (!q.isEmpty()) {
      int[] tmp = q.poll();
      int x = tmp[0];
      int y = tmp[1];
      int broken = tmp[2];
      if (x == N-1 && y == M-1) return dist[x][y][broken];
      
      int nextDist = dist[x][y][broken] + 1;
      for (int dir = 0; dir < dx.length; dir++) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
        if (map[nx][ny] == '0' && dist[nx][ny][broken] == -1) { //이동 가능한 곳이고 아직 방문 X
          dist[nx][ny][broken] = nextDist;
          q.offer(new int[]{nx, ny, broken});
        }
        if (broken == 0 && map[nx][ny] == '1' && dist[nx][ny][1] == -1) { //벽이고, 아직 부순 적 없고, 아직 방문 X
          dist[nx][ny][1] = nextDist;
          q.offer(new int[]{nx, ny, broken});
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    
    map = new char[N][M];
    dist = new int[N][M][2];
    for (int i = 0; i < N; i++) {
      String tmp = br.readLine();
      for (int j = 0; j < M; j++) {
        map[i][j] = tmp.charAt(j);
      }
    }

    System.out.println(solution());
  }
}