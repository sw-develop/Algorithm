import java.util.Scanner;

public class q1 {

	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		//움직일 수 있는 경우의 수 : 8 
		int	dx[] = {2, 2, -2, -2, 1, -1, 1, -1}; //row에 대해 이동할 수 있는 경로 
		int	dy[] = {1, -1, 1, -1, 2, 2, -2, -2}; //col에 대해 이동할 수 있는 경로 
		
		String inputData = kbd.nextLine();
		int col = inputData.charAt(0) - 'a' + 1; //문자로 주어진 좌표를 int로 변환하기 : char to int
		int row = inputData.charAt(1) - '0';
		
		int cnt = 8; //전체 경우의 수 
		
		for(int i = 0; i < dx.length; i++) {
			int col_y = col + dy[i];
			int row_x = row + dx[i];
			
			if(col_y < 1 || col_y > 8 || row_x < 1 || row_x > 8) //조건을 만족하지 않을 때 : 좌표의 범위를 벗어났을 때 
				cnt--;
		}
		
		System.out.println(cnt);
	}

}