import java.util.LinkedList;

public class Main {

	public static boolean[] visited = new boolean[9]; //방문 처리를 위한 배열 
	public static LinkedList<LinkedList<Integer>> graph = new LinkedList<LinkedList<Integer>>(); //그래프 
	
	
	//그래프 간선 추가 
	public static void addEdge(LinkedList<LinkedList<Integer>> graph, int u, int v) {
		graph.get(u).add(v);
	}
	
	//DFS - 재귀함수로 구현 
	public static void dfs(int startVertex) {
		//현재 노드 방문 처리 
		visited[startVertex] = true;
		System.out.print(startVertex + " ");
		//현재 노드와 인접한 다른 노드를 재귀적으로 방문함
		for(int vertex : graph.get(startVertex))
			if(!visited[vertex]) dfs(vertex);
	}
	
	public static void main(String[] args) {
		
		//그래프 초기화
		for(int i = 0; i < 9; i++)
			graph.add(new LinkedList<Integer>()); //각 정점의 연결 리스트 생성 
		
		//그래프 간선 추가 
		addEdge(graph, 1, 2);
		addEdge(graph, 1, 3);
		addEdge(graph, 1, 8);
		
		addEdge(graph, 2, 1);
		addEdge(graph, 2, 7);
		
		addEdge(graph, 3, 1);
		addEdge(graph, 3, 4);
		addEdge(graph, 3, 5);
		
		addEdge(graph, 4, 3);
		addEdge(graph, 4, 5);
		
		addEdge(graph, 5, 3);
		addEdge(graph, 5, 4);
		
		addEdge(graph, 6, 7);
		
		addEdge(graph, 7, 2);
		addEdge(graph, 7, 6);
		addEdge(graph, 7, 8);
		
		addEdge(graph, 8, 1);
		addEdge(graph, 8, 7);
		
		
		
		//DFS (깊이 우선 탐색) 
		dfs(1);

	}

}
