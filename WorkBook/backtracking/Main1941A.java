import java.util.*;
import java.io.*;

public class Main1941A {

  static char[][] stu = new char[5][5];
  static int ans = 0;

  static boolean[] mask = new boolean[25];

  static int[] dx = { -1, 1, 0, 0 };
  static int[] dy = { 0, 0, -1, 1 };

  public static void bfs() { // 함수2 
    Queue<int[]> q = new LinkedList<>();

    boolean[][] isp7 = new boolean[5][5];
    boolean[][] vis = new boolean[5][5];
    for (int i = 0; i < 25; i++) {
      if (mask[i]) { // 7공주로 선택되었음
        int x = i / 5, y = i % 5; // 1차원 배열의 인덱스를 2차원 배열의 인덱스로 매핑
        isp7[x][y] = true;
        if (q.isEmpty()) {
          q.offer(new int[] { x, y });
          vis[x][y] = true;
        }
      }
    }

    int dasom = 0, adj = 0; // 구성원 중 이다솜파의 수, 가로세로로 인접한 사람의 수
    while (!q.isEmpty()) {
      int[] tmp = q.poll();
      int x = tmp[0], y = tmp[1];
      adj++;
      if (stu[x][y] == 'S')
        dasom++;
      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || vis[nx][ny] || !isp7[nx][ny])
          continue;
        q.offer(new int[] { nx, ny });
        vis[nx][ny] = true;
      }
    }

    if (adj >= 7 && dasom >= 4)
      ans += 1;
  }

  public static void solution(int k, int idx) { // 함수1
    // 재귀 종료
    if (k == 7) {
      bfs();
      return;
    }
    // 재귀 수행
    for (int i = idx; i < 25; i++) {
      mask[i] = true;
      solution(k + 1, i + 1);
      mask[i] = false;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    for (int i = 0; i < 5; i++) {
      String s = br.readLine();
      for (int j = 0; j < 5; j++) {
        stu[i][j] = s.charAt(j);
      }
    }

    solution(0, 0);
    System.out.println(ans);
  }
}

/* 문제 회고

<풀이>
주어진 2차원 배열 자체로 bfs 탐색을 하면 중복 제거가 어려움
25개 중 7개 우선 선택한 뒤 조건에 맞는지 확인하자

<구성>
함수1 : 25개의 자리 중 7개 선택 (백트래킹 사용)
함수2 : 선택된 7개의 자리가 모두 상하좌우로 연결되어있는지 확인 & 'S'가 4개 이상 포함되는지 확인 (bfs 사용)

*/
