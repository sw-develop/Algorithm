import java.util.Scanner;
import java.util.Arrays;


public class Q4 {
	public static void main(String[] args) {
		
		Scanner kbd = new Scanner(System.in);
		
		int N = kbd.nextInt();
		int K = kbd.nextInt();
		
		int i = 0;
		int[] arrayA = new int[N];
		int[] arrayB = new int[N]; 		
		for(i = 0; i < N; i++) {
			arrayA[i] = kbd.nextInt();
		}
		for(i = 0; i < N; i++) {
			arrayB[i] = kbd.nextInt();
		}
		
		// 배열 오름차순 정렬 
		Arrays.sort(arrayA);
		Arrays.sort(arrayB);
		
		// 바꿔치기 
		int j = N-1; // 4
		for(i = 0; i < K; i++) {			
			if(arrayA[i] < arrayB[j-i]) {
				arrayA[i] = arrayB[j-i]; // 변수를 정확히 작성하자.. 
			}
			else break;
		}
		
		int total = 0;
		for(i = 0; i < N; i++) 
			total += arrayA[i];
		
		System.out.println(total);
	}
}