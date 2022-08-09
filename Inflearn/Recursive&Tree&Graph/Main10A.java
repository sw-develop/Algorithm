import java.util.*;

public class Main10A {

  static int N, M, answer = 0;
  static int[][] graph;
  static int[] ch;

  public static void dfs(int v) {
    if (v == N)
      answer++;
    else {
      for (int i = 1; i <= N; i++) {
        if (graph[v][i] == 1 && ch[i] == 0) {
          ch[i] = 1;
          dfs(i);
          ch[i] = 0;
        }
      }
    }
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    N = kbd.nextInt(); // 정점 개수
    M = kbd.nextInt(); // 간선 개수
    graph = new int[N + 1][N + 1];
    ch = new int[N + 1];
    for (int i = 0; i < M; i++) {
      graph[kbd.nextInt()][kbd.nextInt()] = 1;
    }
    ch[1] = 1;
    dfs(1);
    System.out.println(answer);
  }
}