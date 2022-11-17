import java.util.*;
import java.io.*;

public class Main2573B {

  static int N, M;
  static int[][] area;

  static int[] dx = {-1, 0, 1, 0};
  static int[] dy = {0, 1, 0, -1};

  
  public static void melting() {
    int[][] zero = new int[N][M]; // 해당 위치 주변의 0의 개수 저장

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (area[i][j] == 0) continue;
        for (int k = 0; k < 4; k++) {
          int nx = i + dx[k];
          int ny = j + dy[k];
          if (area[nx][ny] == 0) zero[i][j] += 1;
        }
      }
    }

    for (int i = 0; i < N; i++) { // 모든 위치에서의 0의 개수 카운트 후 연산 수행
      for (int j = 0; j < M; j++) {
        area[i][j] = Math.max(0, area[i][j] - zero[i][j]);
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

/* 수정한 부분

melting()에서 area[i][j] 값 업데이트 시점 변경
- 모든 위치에서의 주변(동서남북) 0의 개수 카운트 후 area[i][j] 값 연산 수행 (코드가 간결해짐)

*/