import java.util.Arrays;
import java.util.Scanner;

public class q2_Stream {

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
		
		//각 행의 최소값 중 최대값 찾기 
		int max = 0;
		for(i = 0; i < r; i++) {
			int num = Arrays.stream(arr[i]).min().getAsInt(); //배열의 원소 중 최소값 찾기 
			if(num > max) max = num;
		}
			
		System.out.println(max);

	}
}