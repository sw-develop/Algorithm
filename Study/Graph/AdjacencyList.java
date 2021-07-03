/*
 * Adjacency List (인접리스트) 
 */
 
import java.util.LinkedList;

public class AdjacencyList {
	//간선 추가 메서드 (양방향 그래프 일 때) 
	public static void addEdge(LinkedList<LinkedList<Integer>> adjacencyList, int u, int v) {
		adjacencyList.get(u).add(v); 
		adjacencyList.get(v).add(u);
	}

	//인접리스트 출력 
	public static void printAdjacencyList(LinkedList<LinkedList<Integer>> adjacencyList) {
		for(int i = 0; i < adjacencyList.size(); i++) {
			System.out.print(i); //정점 출력 
			for(int v : adjacencyList.get(i)) //각 정점의 연결리스트의 노드들의 데이터값 반환 
				System.out.print(" -> " + v);
			System.out.println(); 
		}
	}
	
	public static void main(String[] args) {
		int vertex = 5; //정점의 개수 
		
		LinkedList<LinkedList<Integer>> adjacencyList = new LinkedList<LinkedList<Integer>>(); 
		for(int i = 0; i < vertex; i++) //정점의 개수만큼 연결리스트 노드 추가 (linkLast) 
			adjacencyList.add(new LinkedList<Integer>());
		
		//간선 추가 
		addEdge(adjacencyList, 0, 1);
		addEdge(adjacencyList, 0, 4);
		addEdge(adjacencyList, 1, 2);
		addEdge(adjacencyList, 1, 3);
		addEdge(adjacencyList, 1, 4);
		addEdge(adjacencyList, 2, 3);
		
		printAdjacencyList(adjacencyList);	
	}

}
