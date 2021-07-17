import java.util.LinkedList;
import java.util.Stack;

public class DFS_stack {

	public static boolean[] visited = new boolean[9]; //방문 처리를 위한 배열 
	public static LinkedList<LinkedList<Integer>> graph = new LinkedList<LinkedList<Integer>>(); //그래프 
	
	//그래프 간선 추가 
	public static void addEdge(LinkedList<LinkedList<Integer>> graph, int u, int v) {
		graph.get(u).add(v);
	}
	
	//DFS - 스택으로 구현 
	public static void dfs(int startVertex) {
		Stack<Integer> st = new Stack<>(); //스택 생성 
		
		st.push(startVertex); //시작 정점 스택 삽입 
		
		while(!st.isEmpty()) {
			startVertex = st.pop();
			if(!visited[startVertex]) { //해당 정점이 방문되지 않았다면 
				visited[startVertex] = true; //방문 체크 
				System.out.print(startVertex + " ");
				for(int vertex : graph.get(startVertex)) //인접 정점 중에서 
					if(!visited[vertex]) st.push(vertex); //방문하지 않은 점정을 스택에 삽입 
			}
		}
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