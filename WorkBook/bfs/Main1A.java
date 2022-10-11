import java.util.*;
import java.io.*;

public class Main1A {

  static StringBuilder ans = new StringBuilder();

  static int yes = 1;
  static int no = 0;
  static int already = 2;

  static int[] dx = { -1, 1, 0, 0 }; // 상하좌우
  static int[] dy = { 0, 0, -1, 1 };

  public static void solution(int N, int M, int[][] board) {
    int cnt = 0;

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (board[i][j] == yes) { // 배추가 있고, 아직 해당 구역에 지렁이 X
          cnt++;
          // 해당 배추 구역에 지렁이 있다고 표시 - BFS
          Queue<int[]> q = new LinkedList<>();
          q.offer(new int[] { i, j });

          while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];

            for (int k = 0; k < dx.length; k++) {
              int nx = x + dx[k];
              int ny = y + dy[k];
              if (nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny] == yes) {
                board[nx][ny] = already;
                q.offer(new int[] { nx, ny });
              }
            }
          }
        }
      }
    }

    ans.append(cnt).append('\n');
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int M = Integer.parseInt(st.nextToken()); // 열 길이
      int N = Integer.parseInt(st.nextToken()); // 행 길이
      int num = Integer.parseInt(st.nextToken());

      int[][] board = new int[N][M];
      while (num-- > 0) {
        st = new StringTokenizer(br.readLine(), " ");
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        board[x][y] = yes; // 배추 표시
      }
      solution(N, M, board);
    }

    System.out.println(ans);
  }
}