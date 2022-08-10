//경로탐색 - 인접리스트

import java.util.*;

public class Main11A {

  static int N, M;
  static ArrayList<ArrayList<Integer>> graph;
  static int[] ch;
  static int answer = 0;

  public static void dfs(int v) {
    if (v == N)
      answer++;
    else {
      for (int nv : graph.get(v)) {
        if (ch[nv] == 0) {
          ch[nv] = 1;
          dfs(nv);
          ch[nv] = 0;
        }
      }
    }
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);

    N = kbd.nextInt();
    M = kbd.nextInt();

    ch = new int[N + 1];

    // 그래프 초기화
    graph = new ArrayList<ArrayList<Integer>>();
    for (int i = 0; i <= N; i++) {
      graph.add(new ArrayList<Integer>());
    }
    // 간선 추가
    for (int i = 0; i < M; i++) {
      int a = kbd.nextInt();
      int b = kbd.nextInt();
      graph.get(a).add(b);
    }

    ch[1] = 1;
    dfs(1); // 시작정점 1
    System.out.println(answer);
  }
}