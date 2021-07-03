import java.util.Scanner;

public class Main {
	public static int lookAt; 
	
	public static void turnLeft() { //개선2 
		lookAt -= 1;
		if(lookAt == -1) lookAt = 3; //북 -> 서 방향 전환 시 
	}

	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		
		int N, M; //직사각형 크기 
		int x, y; //사용자 위치, 바로보고 있는 방향 
		
		N = kbd.nextInt();
		M = kbd.nextInt();
		
		x = kbd.nextInt();
		y = kbd.nextInt();
		lookAt = kbd.nextInt(); //바라보고 있는 방향  
		
		int gameBoard[][] = new int[N][M]; //게임맵 
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				gameBoard[i][j] = kbd.nextInt();
		
		//직관적으로 변수명 표현 ! 
		int visited = 2;
		int ocean = 1;
		int land = 0;
		
		gameBoard[x][y] = visited; //현재 사용자 위치 방문했다고 표시
		
		//북 동 남 서에 따른 이동 거리 -> 개선1 
		int dx[] = {-1, 0, 1, 0}; 
		int dy[] = {0, 1, 0, -1}; 
		
		int moveCount = 0; 
		int turnTime = 0; 
		 
		
		//게임 룰 순서대로 처리해주기 
		while(true) {
			//1. 왼쪽 회전
			turnLeft();
			
			int nx = x + dx[lookAt];
			int ny = y + dy[lookAt];
			
			//2-1. 회전 이후 정면에 가보지 않은 칸이 존재하는 경우 
			if(gameBoard[nx][ny] == land) {
				gameBoard[nx][ny] = visited; //방문 표시
				x = nx; //사용자 위치 업데이트 
				y = ny; 
				moveCount++;
				turnTime = 0;
				continue; //밑의 조건들 확인 필요 없으니까 
			}
			//2-2. 회전 이후 정면에 가보지 않은 칸이 없거나 바다인 경우 
			else turnTime++; 
			
			//3. 네 방향 모두 갈 수 없는 경우
			if(turnTime == 4) {
				nx = x - dx[lookAt];
				ny = y - dx[lookAt]; 
				//뒤로 갈 수 있는 경우 뒤로 이동하기 
				if(gameBoard[nx][ny] != ocean) {
					x = nx; //사용자 위치 업데이트 
					y = ny; 
					moveCount++;
				}
				//뒤가 바다인 경우 이동 불가 
				else break; 
				turnTime = 0; //회전 횟수 초기화 
			}
		}
		
		System.out.println(moveCount);
	}

}