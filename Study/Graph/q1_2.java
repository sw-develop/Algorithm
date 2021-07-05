//DFS 사용 
import java.util.Scanner;

public class Main {

	public static int mapRowSize, mapColSize;
	
	public static int hole = 0, wall = 1, visited = 2;
	
	public static boolean dfs(int iceMap[][], int vertexRow, int vertexCol) {
		//Map의 좌표 범위 체크 
		if(vertexRow <= -1 || vertexRow >= mapRowSize || vertexCol <= -1 || vertexCol >= mapColSize)
			return false;
		
		if(iceMap[vertexRow][vertexCol] == hole) {
			//해당 노드 방문 처리
			iceMap[vertexRow][vertexCol] = visited;
			//상하좌우 좌표에 대해 재귀적 호출 
			dfs(iceMap, vertexRow-1, vertexCol);
			dfs(iceMap, vertexRow+1, vertexCol);
			dfs(iceMap, vertexRow, vertexCol-1);
			dfs(iceMap, vertexRow, vertexCol+1);
			return true; 
		}
		
		return false; 
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
				//현재 위치에서 DFS 수행
				if(dfs(iceMap, i, j))
					 totalIceCream += 1;
			}
		
		System.out.println(totalIceCream);

	}
}
