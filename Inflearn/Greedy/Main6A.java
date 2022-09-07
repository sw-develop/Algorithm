// 38M

import java.util.*;

public class Main6A {

  static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

  static int[][] input;
  static int N, M, f1, f2;

  static int[] ch;
  static String answer = "NO";

  public static void dfs(int v) {
    if (answer.equals("YES"))
      return;
    if (v == f2) {
      answer = "YES";
      return;
    }
    for (int nv : graph.get(v)) {
      if (ch[nv] == 0) {
        ch[nv] = 1;
        dfs(nv);
        ch[nv] = 0;
      }
    }
  }

  public static String solution() {
    // 그래프 인접리스트 구성
    for (int i = 0; i <= N; i++) {
      graph.add(new ArrayList<Integer>());
    }
    for (int i = 0; i < M; i++) {
      // 양방향 그래프
      graph.get(input[i][0]).add(input[i][1]);
      graph.get(input[i][1]).add(input[i][0]);
    }

    // DFS로 경로 탐색
    ch = new int[N + 1];
    ch[f1] = 1;
    dfs(f1);
    return answer;
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    N = kbd.nextInt();
    M = kbd.nextInt();

    input = new int[M][2];
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < 2; j++) {
        input[i][j] = kbd.nextInt();
      }
    }

    f1 = kbd.nextInt();
    f2 = kbd.nextInt();

    System.out.println(solution());
  }
}