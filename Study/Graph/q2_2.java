import java.util.*;

public class Main {

	public static int rowSize, colSize;
	public static int map[][];
	
	/*이동할 4가지 방향 정의*/
	public static int dx[] = {-1, 0, 1, 0}; //북 동 남 서
	public static int dy[] = {0, 1, 0, -1}; 
	
	public static int monster = 0, safe = 1;
	
	public static void dfs(int x, int y) {
		for(int i = 0; i < dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || nx > rowSize-1 || ny < 0 || ny > colSize-1) continue;
			if(map[nx][ny] == monster) continue;
			if(map[nx][ny] == safe) {
				map[nx][ny] = map[x][y] + 1;
				dfs(nx, ny);
			}
		}
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
		
		dfs(0,0); 
		System.out.println(map[rowSize-1][colSize-1]); 
	}
}

