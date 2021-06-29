import java.util.Scanner;


public class q2 {
	
	//시 분 초에서 3이 나올 수 있는 경우에 대해 처리하기 
	public static boolean check(int h, int m, int s) {
		if(h % 10 == 3 || m / 10 == 3 || m % 10 == 3 || s / 10 == 3 || s % 10 == 3)
			return true;
		return false;
	}

	public static void main(String[] args) {
		//3, 13, 23 , 30~39, 43, 53
		
		Scanner kbd = new Scanner(System.in);
		
		int N = kbd.nextInt();
		
		int count = 0;
		
		for(int i = 0; i < N+1; i++)
			for(int k = 0; k < 60; k++)
				for(int j = 0; j < 60; j++) {
					if(check(i,k,j)) count++;
				}
		
		System.out.println(count);
					
	}

}