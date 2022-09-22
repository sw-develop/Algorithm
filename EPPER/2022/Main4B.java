import java.util.*;

class Solution {

  static boolean[][][] board;

  public static boolean validate(int x, int y, int a, int n) {
    if (a == 0) { // 기둥
      if (y == 0) { // 바닥 위
        return true;
      }
      if (x > 0 && board[x - 1][y][1]) { // 보의 오른쪽 끝 부분 위
        return true;
      }
      if (board[x][y][1]) { // 보의 왼쪽 끝 부분 위
        return true;
      }
      if (y > 0 && board[x][y - 1][0]) { // 다른 기둥 위
        return true;
      }
    } else { // 보
      if (y > 0 && board[x][y - 1][0]) { // 한쪽 끝 부분 기둥 위
        return true;
      }
      if (x < n && y > 0 && board[x + 1][y - 1][0]) { // 한쪽 끝 부분 기둥 위
        return true;
      }
      if (x > 0 && x < n && board[x - 1][y][1] && board[x + 1][y][1]) { // 양쪽이 다른 보와 동시 연결
        return true;
      }
    }
    return false;
  }

  public static boolean isRemovable(int x, int y, int a, int n) {
    int[] dx = { -1, 0, 1 };
    int[] dy = { -1, 0, 1 };

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        int nx = x + dx[i];
        int ny = y + dy[j];
        if (nx >= 0 && nx <= n && ny >= 0 && ny <= n) {
          for (int k = 0; k < 2; k++) {
            if (board[nx][ny][k] && !validate(nx, ny, k, n)) {
              return false;
            }
          }
        }
      }
    }
    return true;
  }

  public int[][] solution(int n, int[][] build_frame) {
    int[][] answer = {};

    board = new boolean[n + 1][n + 1][2];

    // build_frame 원소 하나씩 확인하며 수행
    for (int i = 0; i < build_frame.length; i++) {
      int x = build_frame[i][0];
      int y = build_frame[i][1];
      int a = build_frame[i][2];
      int cmd = build_frame[i][3];
      if (cmd == 0) { // 삭제
        board[x][y][a] = false; // 일단 삭제 수행
        if (!isRemovable(x, y, a, n)) {
          board[x][y][a] = true;
        }
      } else { // 설치
        if (validate(x, y, a, n)) {
          board[x][y][a] = true;
        }
      }
    }

    // 결과 반환
    ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= n; j++) {
        for (int k = 0; k < 2; k++) {
          if (board[i][j][k]) {
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.add(i);
            tmp.add(j);
            tmp.add(k);
            ans.add(tmp); // 주의!
          }
        }
      }
    }

    answer = new int[ans.size()][3];
    for (int i = 0; i < ans.size(); i++) {
      answer[i][0] = ans.get(i).get(0);
      answer[i][1] = ans.get(i).get(1);
      answer[i][2] = ans.get(i).get(2);
    }

    return answer;
  }
}