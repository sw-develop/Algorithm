import java.util.Scanner;
import java.util.Arrays;

class q2 {

	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		int i = 0, j = 0;
		
		//행, 열 값 입력
		int r, c;
		r = kbd.nextInt();
		c = kbd.nextInt();
		
		//2차원 배열 값 입력 
		int arr[][] = new int[r][c];
		for(i = 0; i < r; i++) 
			for(j = 0; j < c; j++)
				arr[i][j] = kbd.nextInt();
		
		for(i = 0; i < r; i++)
			Arrays.sort(arr[i]); //2차원 배열의 각 행을 오름차순 정렬하기 
		
		//각 행의 최소값들 중 최대값 찾기
		int max = 0;
		for(i = 0; i < r; i++) 
			if(max < arr[i][0]) max = arr[i][0];
		
		System.out.println(max);

	}

}