import java.util.Scanner;

public class q3_1 {
	public static void main(String[] args) {
		//while문 돌리고 -> K로 나눠떨어질때는 무조건 나누고 & 아니면 N-1하고 
		Scanner kbd = new Scanner(System.in);
		
		int N, K;
		N = kbd.nextInt();
		K = kbd.nextInt();
		
		int count = 0; //수행 횟수 
		while(true) {
			if(N == 1) break;
			else {
				if(N%K == 0) N /= K;
				else N -= 1;
				count++;
			}
		}
		
		System.out.println(count);
	}

}