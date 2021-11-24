import java.util.Scanner;

// 문제를 풀며 든 생각😲
// 경우의 수로 모든 경우에 대해 생각해봐야 할 것 같은데 너무 많은 것 아니야..? -> 맞아! 경우의 수로 모든 경우에 대해 봐야되는거 맞는데 다이나믹 프로그래밍을 사용해서 빠르게 구하는거지!

public class Q1 {
	public static int[] result = new int[30001];	// 배열의 원소 값 : 해당 값에 대한 연산 횟수의 최솟값 
	
	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		
		int val = kbd.nextInt();	// 최대 : 30,000 

		for(int i = 2; i <= val; i++) {
			// 연산1. 현재의 수 - 1
			result[i] = result[i-1] + 1;
			
			// 연산2. 현재의 수가 2로 나누어 떨어지는 경우
			if (i % 2 == 0)
				result[i] = Math.min(result[i], result[i/2] + 1);
			
			// 연산3. 현재의 수가 3으로 나누어 떨어지는 경우
			if (i % 3 == 0)
				result[i] = Math.min(result[i], result[i/3] + 1);
			
			// 연산4. 현재의 수가 5로 나누어 떨어지는 경우 
			if (i % 5 == 0)
				result[i] = Math.min(result[i], result[i/5] + 1);
		}
		
		
		// 연산 하는 횟수의 최솟값 구하기 
		System.out.println(result[val]);
	}

}