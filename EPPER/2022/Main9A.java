import java.util.*;

public class Main9A {
	
	static final int INF = (int) 1e9;

	public static int solution(int n, int s, int a, int b, int[][] fares, int lay) {
		int answer = INF;
		
		//1.모든 경로에 대한 최소 가중치 값 구하기
		
		//그래프 초기화
		int[][] graph = new int[n+1][n+1];
		for (int i = 1; i <= n; i++) {
			Arrays.fill(graph[i], INF);
			graph[i][i] = 0; //자기자신은 0으로 초기화
		}
		
		for (int i = 0; i < fares.length; i++) {
			int v1 = fares[i][0];
			int v2 = fares[i][1];
			int w = fares[i][2];
			graph[v1][v2] = w;
			graph[v2][v1] = w;
		}
		
		//플로이드-워셜 알고리즘 사용
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
				}
			}
		}
		
		//2.구하는 값 계산
		for (int i = 1; i <= n; i++) {
			answer = Math.min(answer, graph[s][lay] + graph[lay][i] + graph[i][a] + graph[i][b]);
		}
		
		return answer;
	}
  
}