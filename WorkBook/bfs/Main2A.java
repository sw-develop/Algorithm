import java.util.*;
import java.io.*;

public class Main2A {

  static char checked = 'X';

  static int[] dx = { -1, 1, 0, 0 };
  static int[] dy = { 0, 0, -1, 1 };

  public static int solA(int N, char[][] board) { // 적록색약 아닌 사람
    int ans = 0;

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (board[i][j] != checked) {
          ans++;
          // 동일 구역 범위 확인해 체크 표시 - BFS
          Queue<int[]> q = new LinkedList<>();
          q.offer(new int[] { i, j });
          char color = board[i][j];
          board[i][j] = checked;

          while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];

            for (int k = 0; k < dx.length; k++) {
              int nx = x + dx[k];
              int ny = y + dy[k];
              if (nx >= 0 && nx < N && ny >= 0 && ny < N && board[nx][ny] == color) {
                q.offer(new int[] { nx, ny });
                board[nx][ny] = checked;
              }
            }
          }
        }
      }
    }

    return ans;
  }

  public static int solB(int N, char[][] board) { // 적록색약인 사람
    int ans = 0;

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (board[i][j] != checked) {
          ans++;
          // 동일 구역 범위 확인해 체크 표시 - BFS
          Queue<int[]> q = new LinkedList<>();
          q.offer(new int[] { i, j });
          char color = board[i][j];
          board[i][j] = checked;

          while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];

            for (int k = 0; k < dx.length; k++) {
              int nx = x + dx[k];
              int ny = y + dy[k];
              if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (color == 'R' || color == 'G') {
                  if (board[nx][ny] == 'R' || board[nx][ny] == 'G') {
                    q.offer(new int[] { nx, ny });
                    board[nx][ny] = checked;
                  }
                } else {
                  if (board[nx][ny] == color) {
                    q.offer(new int[] { nx, ny });
                    board[nx][ny] = checked;  
                  }
                }
              }
            }
          }
        }
      }
    }

    return ans;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    char[][] boardA = new char[N][N];
    char[][] boardB = new char[N][N]; 
    for (int i = 0; i < N; i++) {
      String tmp = br.readLine();
      for (int j = 0; j < N; j++) {
        boardA[i][j] = tmp.charAt(j);
        boardB[i][j] = tmp.charAt(j);
      }
    }
    System.out.println(solA(N, boardA) + " " + solB(N, boardB));
  }
}
