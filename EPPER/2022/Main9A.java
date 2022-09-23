import java.util.*;

public class Main9A {

  static final int INF = (int) 1e9;
  static int[][] graph;

  public static int solution(int n, int s, int a, int b, int[][] fares, int lay) {
    // n - 노드 개수, s - 시작지점, lay - 경유지

    int answer = INF;

    // 1. 그래프 구성
    graph = new int[n + 1][n + 1];

    for (int i = 1; i <= n; i++) {
      Arrays.fill(graph[i], INF);
      graph[i][i] = 0; // 자기 자신으로의 비용은 0
    }

    for (int i = 0; i < fares.length; i++) {
      int n1 = fares[i][0];
      int n2 = fares[i][1];
      int weight = fares[i][2];
      graph[n1][n2] = weight;
    }

    // 2. 플로이드-워셜 알고리즘 적용
    for (int k = 1; k <= n; k++) {
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
          graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
        }
      }
    }

    // 3. 최소 비용 계산
    // graph[s][lay] + graph[lay][i] + graph[i][a] + graph[i][b]의 최소값
    for (int i = 1; i <= n; i++) {
      answer = Math.min(answer, graph[s][lay] + graph[lay][i] + graph[i][a] + graph[i][b]);
    }

    return answer;
  }
}