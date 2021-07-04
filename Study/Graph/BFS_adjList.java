import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static boolean[] visited = new boolean[9];
	public static LinkedList<LinkedList<Integer>> graph = new LinkedList<LinkedList<Integer>>();
	
	public static void addEdge(LinkedList<LinkedList<Integer>> graph, int u, int v) {
		graph.get(u).add(v);
	}
	
	//BFS 정의 
	public static void bfs(int startVertex) {
		Queue<Integer> q = new LinkedList<>(); //큐 선언 
		
		q.offer(startVertex); //시작 노드 큐에 삽입 
		visited[startVertex] = true; //시작 노드 방문 처리 
		
		//빈 큐가 될 때까지 반복
		while(!q.isEmpty()) {
			int vertex = q.poll(); //dequeue 
			System.out.print(vertex + " ");
			
			//해당 정점과 인접하지만 아직 방문하지 않은 원소들을 큐에 삽입
			for(int v : graph.get(vertex))
				if(!visited[v]) {
					q.offer(v); //enqueue 
					visited[v] = true;
				}
		}
	}
	
	public static void main(String[] args) {
		//그래프 초기화 
		for(int i = 0; i < 9; i++)
			graph.add(new LinkedList<Integer>());
		 
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
				
		//BFS (넓이 우선 탐색) 
		bfs(1);
	}

}