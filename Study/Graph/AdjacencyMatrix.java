/*
 * Adjacency Array(인접행렬) 
 */

class ArrGraph{
	private int[][] arrGraph; 
	
	//그래프 초기화 
	public ArrGraph(int graphSize) {
		//vertex가 1부터 시작할 때
		this.arrGraph = new int[graphSize+1][graphSize+1];
	}
	
	//그래프 return 
	public int[][] getGraph() {
		return this.arrGraph;
	}
	
	//그래프 추가 (단방향)
	public void putSingleEdge(int x, int y) {
		arrGraph[x][y] = 1;
	}
	
	//그래프 추가 (양방향) 
	public void putEdge(int x, int y) {
		arrGraph[x][y] = 1;
		arrGraph[y][x] = 1;
	}
	
	//그래프 출력 
	public void printGraph() {
		for(int i = 0; i < arrGraph.length; i++) {
			for(int j = 0; j < arrGraph[i].length; j++)
				System.out.print("[" + arrGraph[i][j] + "]");
			System.out.println();
		}
	}
}


public class AdjacencyMatrix {
	
	public static void main(String[] args) {
		int graphSize = 6;
		ArrGraph adjMatrix = new ArrGraph(graphSize);
		
		adjMatrix.putEdge(1, 2);
		adjMatrix.putEdge(1, 3);
		adjMatrix.putEdge(2, 3);
		adjMatrix.putEdge(2, 4);
		adjMatrix.putEdge(3, 5);
		
		adjMatrix.printGraph();
	}

}
