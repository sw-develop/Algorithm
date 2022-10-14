//1초 동안 - 불 번짐, 상근이 이동
//좌표 - 벽 / 상근이 방문 / 불 / 빈공간

import java.util.*;
import java.io.*;

public class Main5A {

  static StringBuilder ans = new StringBuilder();

  static int[] dx = { 0, 0, 1, -1 }; // 동서남북
  static int[] dy = { 1, -1, 0, 0 };

  static char checked = '@'; // 상근이가 이미 이동한 좌표 체크

  public static void solution(int row, int col, char[][] map, int curRow, int curCol) {
    Queue<int[]> fire = new LinkedList<>(); // 불 좌표 저장 큐
    Queue<int[]> move = new LinkedList<>(); // 상근이 이동 가능 좌표 저장 큐
    // fire 큐 초기화
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (map[i][j] == '*') {
          fire.offer(new int[] { i, j });
        }
      }
    }
    // move 큐 초기화
    move.offer(new int[] { curRow, curCol });
    map[curRow][curCol] = checked;

    // BFS
    int cnt = 0;
    boolean escaped = false;
    while (!move.isEmpty() && !escaped) {
      cnt++;
      
      // 불 확산 처리 먼저 해야 함
      int fireL = fire.size();
      for (int i = 0; i < fireL; i++) {
        int[] tmp = fire.poll();
        int x = tmp[0];
        int y = tmp[1];
        for (int idx = 0; idx < dx.length; idx++) {
          int nx = x + dx[idx];
          int ny = y + dy[idx];
          //불 확산 - 빈 공간 / 상근이 왔다감
          if (nx < 0 || nx >= row || ny < 0 || ny >= col) continue;
          if (map[nx][ny] == '.' || map[nx][ny] == checked) {
            fire.offer(new int[]{nx, ny});
            map[nx][ny] = '*';
          }
        }
      }
      // 상근이 이동 처리
      int moveL = move.size();
      for (int i = 0; i < moveL; i++) {
        int[] tmp = move.poll();
        int x = tmp[0];
        int y = tmp[1];
        if (x == 0 || x == row - 1 || y == 0 || y == col - 1) { // 탈출 가능 조건 확인
          escaped = true;
          break;
        }
        for (int idx = 0; idx < dx.length; idx++) {
          int nx = x + dx[idx];
          int ny = y + dy[idx];
          //상근이 이동 - 빈 공간
          if (nx < 0 || nx >= row || ny < 0 || ny >= col) continue;
          if (map[nx][ny] == '.') {
            move.offer(new int[] { nx, ny });
            map[nx][ny] = checked;
          }
        }
      }
    }

    if (escaped)
      ans.append(cnt).append('\n');
    else
      ans.append("IMPOSSIBLE").append('\n');
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());
    StringTokenizer st;
    while (T-- > 0) {
      st = new StringTokenizer(br.readLine());
      int w = Integer.parseInt(st.nextToken()); //col
      int h = Integer.parseInt(st.nextToken()); //row
      char[][] map = new char[h][w];
      int curRow = 0, curCol = 0; // 현재 상근이 위치
      for (int i = 0; i < h; i++) {
        String tmp = br.readLine();
        for (int j = 0; j < w; j++) {
          map[i][j] = tmp.charAt(j);
          if (map[i][j] == '@') {
            curRow = i;
            curCol = j;
          }
        }
      }
      solution(h, w, map, curRow, curCol);
    }

    System.out.println(ans);
  }
}