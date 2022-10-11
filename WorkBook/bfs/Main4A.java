import java.util.*;
import java.io.*;

public class Main4A {

  static StringBuilder ans = new StringBuilder();

  static int[] dx = { -2, -1, 1, 2, 2, 1, -1, -2 };
  static int[] dy = { 1, 2, 2, 1, -1, -2, -2, -1 };

  static int checked = 1;

  public static void solution(int l, int[][] board, int curRow, int curCol, int tarRow, int tarCol) {
    int move = 0;

    Queue<int[]> q = new LinkedList<>(); // 현재 위치 좌표 저장
    q.offer(new int[] { curRow, curCol });
    board[curRow][curCol] = checked;

    boolean arrive = false;
    while (!q.isEmpty()) {
      int L = q.size();

      for (int i = 0; i < L; i++) {
        int[] tmp = q.poll();
        int x = tmp[0];
        int y = tmp[1];
        if (x == tarRow && y == tarCol) {
          arrive = true;
          break;
        }
        for (int idx = 0; idx < dx.length; idx++) { // 이동 가능 위치 업데이트
          int nx = x + dx[idx];
          int ny = y + dy[idx];
          if (nx >= 0 && nx < l && ny >= 0 && ny < l && board[nx][ny] != checked) {
            q.offer(new int[] { nx, ny });
            board[nx][ny] = checked;
          }
        }
      }

      if (arrive)
        break;

      move++;
    }

    ans.append(move).append('\n');
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());
    StringTokenizer st;
    while (T-- > 0) {
      int l = Integer.parseInt(br.readLine());
      int[][] board = new int[l][l];

      st = new StringTokenizer(br.readLine(), " ");
      int curRow = Integer.parseInt(st.nextToken());
      int curCol = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine(), " ");
      int tarRow = Integer.parseInt(st.nextToken());
      int tarCol = Integer.parseInt(st.nextToken());

      solution(l, board, curRow, curCol, tarRow, tarCol);
    }

    System.out.println(ans);
  }
}

/*
 * 문제 회고
 * 
 * 이미 탐색한 좌표 표시를 해주지 않아 메모리 초과가 발생함
 * 
 */