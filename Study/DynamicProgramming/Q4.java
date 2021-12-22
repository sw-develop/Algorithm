import java.util.*;

public class Q4 {	
	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		
		int N = kbd.nextInt();
		int M = kbd.nextInt();
		
		// 화폐 가치 입력 
		int[] coins = new int[N];
		for(int i = 0; i < N; i++) {
			coins[i] = kbd.nextInt();
		}
		
		// 한 번 계산된 결과를 저장하기 위한 DP 테이블 초기화 
		// 방법1. for문
		// 방법2. Arrays.fill()
		int[] d = new int[M+1];
		Arrays.fill(d, 10001);
		
		// 다이나믹 프로그래밍 진행 (보텀업 방식)
		d[0] = 0;	// 0원을 만들기 위해 필요한 최소한의 화폐 개수 
		for(int i = 0; i < N; i++) {
			for(int j = coins[i]; j <= M; j++) {
				// (i-k)원을 만드는 방법이 존재하는 경우 
				if(d[j - coins[i]] != 10001) {
					d[j] = Math.min(d[j], d[j-coins[i]]+1);
				}
				
			}
		}
		
		// 계산 결과 출력
		if(d[M] == 10001) System.out.println(-1);	// 최종적으로 M원을 만드는 방법이 없는 경우 
		else	System.out.println(d[M]);
	}
}