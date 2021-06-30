import java.util.Scanner;

public class Main {
	
	public static void whereCanImove(int lookAt, int moveRow[], int moveCol[]) {
		if(lookAt == 0) { //북쪽 
			moveRow[0] = 0;
			moveRow[1] = 1;
			moveRow[2] = 0;
			moveCol[0] = -1;
			moveCol[1] = 0;
			moveCol[2] = 1;
		}
		else if(lookAt == 1) { //동쪽 
			moveRow[0] = -1;
			moveRow[1] = 0;
			moveRow[2] = 1;
			moveCol[0] = 0;
			moveCol[1] = -1;
			moveCol[2] = 0;
		}
		else if(lookAt == 2) { //남쪽 
			moveRow[0] = 0;
			moveRow[1] = -1;
			moveRow[2] = 0;
			moveCol[0] = 1;
			moveCol[1] = 0;
			moveCol[2] = -1;
		}
		else { //서쪽 
			moveRow[0] = 1;
			moveRow[1] = 0;
			moveRow[2] = -1;
			moveCol[0] = 0;
			moveCol[1] = 1;
			moveCol[2] = 0;
		}
	}
	

	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		
		int N, M; //직사각형 크기 
		int x, y, lookAt; //사용자 위치, 바로보고 있는 방향 
		
		N = kbd.nextInt();
		M = kbd.nextInt();
		
		x = kbd.nextInt();
		y = kbd.nextInt();
		lookAt = kbd.nextInt(); //바라보고 있는 방향  
		
		int gameBoard[][] = new int[N][M];
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				gameBoard[i][j] = kbd.nextInt();
		
		
		int moveRow[] = new int[3]; //바라보는 방향에 따라 이동 가능한 row 값 저장 배열 
		int moveCol[] = new int[3]; //바라보는 방향에 따라 이동 가능한 col 값 저장 배열 
		
		//직관적으로 변수명 표현 ! 
		int visited = 2;
		int ocean = 1;
		int land = 0;
		
		int dx = 0;
		int dy = 0;
		
		boolean moveSuccess = false; 
		
		int moveCount = 0; 
		
		gameBoard[x][y] = visited; //현재 사용자 위치 방문했다고 표시 
		
		while(true) {
			
			System.out.println("game start!");
			
			moveSuccess = false; //초기화 -> 놓친 부분1! 
			
			whereCanImove(lookAt, moveRow, moveCol);
			
			for(int i = 0; i < 3; i++) {
				if(lookAt-1 < 0) lookAt = 3; //북쪽일 때 처리 -> 놓친 부분2!
				else lookAt--;
				
				dx = x + moveRow[i]; 
				dy = y + moveCol[i];
				
				if(dx != -1 && dx != M && dy != -1 && dy != N) { //게임 맵 범위를 벗어나지 않았을 때 
					if(gameBoard[dx][dy] == land) { //아직 가보지 않은 칸이 존재할 때 
						x = dx;
						y = dy;
						moveSuccess = true;
						moveCount++;
						gameBoard[x][y] = visited;
					}
				}
				
				if(moveSuccess) break;
			}
			
			if(!moveSuccess) {
				if(lookAt-1 < 0) lookAt = 3; //북쪽일 때 처리 
				else lookAt--; 
				
				//바라보는 방향 따라 달라짐 -> 한 칸 뒤로 이동 
				if(lookAt == 0) { //북 
					if(x+1 != M) x = x+1;
				}
				else if(lookAt == 1) { //동 
					if(y-1 != -1) y = y-1;
				}
				else if(lookAt == 2) { //남 
					if(x-1 != -1) x = x-1;
				}
				else { //서 
					if(y+1 != N) y = y+1;
				}
				
				if(gameBoard[x][y] == ocean) //이동한 곳이 바다일 때 
					break;
				else 
					moveCount++;
			}
			
		}
		
		System.out.println(moveCount);
	}

}