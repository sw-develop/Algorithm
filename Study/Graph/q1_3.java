import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair{
	public int row;
	public int col;
	
	Pair(int row, int col){
		this.row = row;
		this.col = col;
	}
}

public class Main {

public static int mapRowSize, mapColSize;
	
	public static int dx[] = {-1, 1, 0, 0}; //행의 움직임 (상하좌우)
	public static int dy[] = {0, 0, -1, 1}; //열의 움직임 (상하좌우) 
	
	public static int hole = 0, wall = 1, visited = 2;
	
	public static void bfs(int iceMap[][], int startVertexRow, int startVertexCol) { 
		Queue<Pair> queue = new LinkedList<Pair>();
		
		Pair pair = new Pair(startVertexRow, startVertexCol);
		
		queue.offer(pair);
		iceMap[startVertexRow][startVertexCol] = visited; 
		
		while(!queue.isEmpty()) {
			Pair dequeueVal = queue.poll();
			startVertexRow = dequeueVal.row; 
			startVertexCol = dequeueVal.col;
			
			for(int i = 0; i < dx.length; i++) {
				int x = startVertexRow + dx[i]; //row -> 헷갈린 부분 : x가 좌표에서의 x값이 아니라 행임! 
				int y = startVertexCol + dy[i]; //col -> y는 열임! 
				
				if(x != -1 && x != mapRowSize && y != -1 && y != mapColSize) { //x좌표 -> col, y좌표 -> row 
					if(iceMap[x][y] == hole) {
						pair = new Pair(x, y);
						queue.offer(pair);
						iceMap[x][y] = visited; 
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		
		mapRowSize = kbd.nextInt();
		mapColSize = kbd.nextInt();
		kbd.nextLine(); //버퍼 지우기 
		
		int iceMap[][] = new int[mapRowSize][mapColSize]; //그래프의 경우 -> 인접행렬이라고 생각하기 
		
		/* 2차원 리스트의 맵 정보 입력 받기 */
		for(int i = 0; i < mapRowSize; i++) {
			String str = kbd.nextLine(); //문자열로 입력받기 
			for(int j = 0; j < mapColSize; j++) {
				iceMap[i][j] = str.charAt(j) - '0'; //Char to Int 
			}
		}
			
		
		int totalIceCream = 0; 
		
		for(int i = 0; i < mapRowSize; i++)
			for(int j = 0; j < mapColSize; j++) {
				if(iceMap[i][j] == hole) {
					bfs(iceMap, i, j);
					totalIceCream++; 
				}
			}
		
		System.out.println(totalIceCream);
	}
}