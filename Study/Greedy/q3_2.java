import java.util.Scanner;

public class q3_2 {

	public static void main(String[] args) {
		//while문 돌리고 -> K로 나눠떨어질때는 무조건 나누고 & 아니면 N-1하고 
				Scanner kbd = new Scanner(System.in);
				
				int N, K;
				N = kbd.nextInt();
				K = kbd.nextInt();
				
				int count = 0, target; //수행 횟수
				while(true) {
					//N%K == 0이 될 때까지 1씩 한번에 빼기 
					target = (N/K)*K; 
					count += (N-target);
					N = target;
					//반복 끝낼 조건 : N이 K보다 작을 때(더 이상 나눌 수 없을 때)
					if(N < K) break;
					//K로 나누기
					count++;
					N /= K;
				}
				
				count += (N-1);
				System.out.println(count);
	}
}
