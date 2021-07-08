//DFS  - 미로찾기 -> 알게된 점 : 미로라고 다 dfs는 아니다..!! -> 근데 dfs로도 가능하긴함 -> 이거랑 똑같이 각 원소값을 이동 횟수에 대한 가중치로 생각해주면 됨 
//BFS 사용 -> 2차원 배열의 원소값을 가중치라고 했을 때, 방문한 노드의 가중치 증가시키기 -> 원소값으로 이동 횟수 세기 
//자신 노드와 상하좌우에 있는 노드까지의 이동거리는 동일하니까 

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node{
	private int x;
	private int y;
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y; 
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
}

public class Main {

	public static int rowSize, colSize;
	public static int map[][];
	
	/*이동할 4가지 방향 정의*/
	public static int dx[] = {-1, 0, 1, 0}; //북 동 남 서
	public static int dy[] = {0, 1, 0, -1}; 
	
	public static int monster = 0, safe = 1;
	
	public static int bfs(int x, int y) { //x - row, y - col
		Queue<Node> q = new LinkedList<>(); 
		q.offer(new Node(x, y)); //Node 객체 생성 & enqueue 한번에 하기(코드 줄이기) 
		
		//빈 큐일때까지 반복 
		while(!q.isEmpty()) {
			Node node = q.poll();
			x = node.getX(); //현재 위치 재설정 
			y = node.getY(); 
			
			//현재 위치에서 4가지 방향으로의 위치 확인
			for(int i = 0; i < dx.length; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				//해당 위치의 원소값이 조건을 만족하는지 확인
				//1. 미로 공간 벗어난 경우
				if(nx < 0 || nx >= rowSize || ny < 0 || ny >= colSize) continue; 
				//2. 몬스터가 있는 경우 
				if(map[nx][ny] == monster) continue; 
				//3. 해당 노드를 처음 방문하는 경우 
				if(map[nx][ny] == safe) {
					map[nx][ny] = map[x][y] + 1; //이동 횟수에 대한 가중치 값(원소값) 증가 
					q.offer(new Node(nx, ny));
					
				}
			}
		}
		
		//최종 위치의 이동 횟수에 대한 가중치 반환(최단거리 반환) 
		return map[rowSize-1][colSize-1];
	}

	
	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);

		rowSize = kbd.nextInt();
		colSize = kbd.nextInt();
		kbd.nextLine();
		
		//2차원 배열 MAP 원소값 입력 
		map = new int[rowSize][colSize];
		for(int i = 0; i < rowSize; i++) {
			String str = kbd.nextLine();
			for(int j = 0; j < colSize; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		//BFS 수행 결과 출력 
		System.out.println(bfs(0,0)); 
	}

}
