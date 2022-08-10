// 그래프 최단거리 - 인접리스트, BFS, 거리 배열에 저장

import java.util.*;

public class Main12A {

  static int N, M;
  static ArrayList<ArrayList<Integer>> graph;
  static int[] ch;
  static int[] dis;

  public static void shortestPath(int start) {
    Queue<Integer> q = new LinkedList<>();
    q.offer(start); // 시작 정점
    ch[start] = 1;
    while (!q.isEmpty()) {
      int len = q.size();
      for (int i = 0; i < len; i++) {
        int v = q.poll();
        for (int nv : graph.get(v)) {
          if (ch[nv] == 0) {
            ch[nv] = 1;
            dis[nv] = dis[v] + 1; // 최단거리 업데이트
            q.offer(nv);
          }
        }
      }
    }
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    N = kbd.nextInt(); // 정점 수
    M = kbd.nextInt(); // 간선 수

    // 인접리스트
    graph = new ArrayList<ArrayList<Integer>>();
    for (int i = 0; i <= N; i++) {
      graph.add(new ArrayList<Integer>());
    }
    for (int i = 0; i < M; i++) {
      int a = kbd.nextInt();
      int b = kbd.nextInt();
      graph.get(a).add(b);
    }

    ch = new int[N + 1];
    dis = new int[N + 1];

    shortestPath(1);

    for (int i = 2; i <= N; i++) {
      System.out.print(dis[i] + " ");
    }
  }
}