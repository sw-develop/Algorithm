import java.util.*;
import java.io.*;

public class Main {

  static int N, M;
  static char[][] map;
  static int[][][] dist;
  //dist[x][y][0] : 벽을 하나도 부수지 않고 (x, y)까지 오는데 걸리는 비용
  //dist[x][y][1] : 벽을 하나만 부수고 (x, y)까지 오는데 걸리는 비용

  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};

  public static int solution() {
    dist = new int[N][M][2];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        dist[i][j][0] = dist[i][j][1] = -1;
      }
    }

    dist[0][0][0] = 1;
    Queue<int[]> q = new LinkedList<>(); //좌표(x,y)와 벽 부순 횟수 저장
    q.offer(new int[]{0, 0, 0});

    while (!q.isEmpty()) { //BFS
      int[] tmp = q.poll();
      int x = tmp[0];
      int y = tmp[1];
      int broken = tmp[2];
      if (x == N-1 && y == M-1) return dist[x][y][broken];

      int nextDist = dist[x][y][broken] + 1;
      for (int idx = 0; idx < dx.length; idx++) {
        int nx = x + dx[idx];
        int ny = y + dy[idx];
        if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
        //벽이 아니고 아직 방문 X
        if (map[nx][ny] == '0' && dist[nx][ny][broken] == -1) {
          q.offer(new int[]{nx, ny, broken});
          dist[nx][ny][broken] = nextDist;
        }
        //아직 벽을 부순 적 없고, 벽이고, 아직 방문 X
        if (broken == 0 && map[nx][ny] == '1' && dist[nx][ny][1] == -1) {
          q.offer(new int[]{nx, ny, 1});
          dist[nx][ny][1] = nextDist;
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
    for (int i = 0; i < N; i++) {
      String tmp = br.readLine();
      for (int j = 0; j < M; j++) {
        map[i][j] = tmp.charAt(j);
      }
    }

    System.out.println(solution());
  }
}

/*
문제 회고

좌표까지 도달할 수 있는 경우가 여러가지 일 때 3차원 배열 활용하기

*/