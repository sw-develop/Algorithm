import java.util.*;
import java.io.*;

public class Main2573A {

  static int N, M;
  static int[][] area;
  static boolean[][] turnToZero; // 0 값이 원래 0이었는지(false) 지금 0이 된 것이지(true)

  static int[] dx = {-1, 0, 1, 0};
  static int[] dy = {0, 1, 0, -1};

  
  public static void melting() {
    turnToZero = new boolean[N][M]; 

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (area[i][j] == 0) continue;
        int cnt = 0;
        for (int k = 0; k < 4; k++) {
          int nx = i + dx[k];
          int ny = j + dy[k];
          if (area[nx][ny] == 0 && !turnToZero[nx][ny]) cnt += 1;
        }
        area[i][j] = area[i][j] - cnt;
        if (area[i][j] <= 0) { // <= 여기에서 등호를 처음에 놓침
          area[i][j] = 0;
          turnToZero[i][j] = true;
        }
      }
    }
  }

  public static int getNumOfIce() {
    int ice = 0;

    boolean[][] visited = new boolean[N][M];

    Queue<int[]> q = new LinkedList<>();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (visited[i][j]) continue;
        if (area[i][j] == 0) {
          visited[i][j] = true;
          continue;
        }
        ice += 1;
        q.offer(new int[]{i, j});
        while (!q.isEmpty()) {
          int[] tmp = q.poll();
          int x = tmp[0];
          int y = tmp[1];
          for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (!visited[nx][ny] && area[nx][ny] != 0) {
              q.offer(new int[]{nx, ny});
              visited[nx][ny] = true;
            }
          }
        }
      }
    }

    return ice;
  }
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] str = br.readLine().split(" ");
    N = Integer.parseInt(str[0]);
    M = Integer.parseInt(str[1]);

    area = new int[N][M];
    for (int i = 0; i < N; i++) {
      str = br.readLine().split(" ");
      for (int j = 0; j < M; j++) {
        area[i][j] = Integer.parseInt(str[j]);
      }
    }

    int ice = 1;
    int year = 0;
    while (ice == 1) {
      melting();
      ice = getNumOfIce();
      year += 1;
    }

    if (ice == 0) System.out.println(0);
    else System.out.println(year);
  }
}

/* 문제회고

구성
- 완전 탐색
- 1년 뒤 빙산의 상태 구하기 -> 함수1
- 빙산의 개수 구하기 -> 함수2

주의
- 틀렸다면, 문제를 다시 읽고 빠진 조건이 있는지 확인하기 (코테볼 때 내가 놓치는 부분임)

*/