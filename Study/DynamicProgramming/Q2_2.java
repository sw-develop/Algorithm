import java.util.Scanner;

public class Q2_2 {

  // 앞서 계산된 결과 저장을 위한 DP 테이블 초기화 
	public static int[] result = new int[100];
	
	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		
    // 식량창고 개수 입력 
		int N = kbd.nextInt();
		
    // 식량창고 별 저장된 식량 개수 입력 
		int[] numOfFood = new int[N];
		for(int i = 0; i < N; i++) {
			numOfFood[i] = kbd.nextInt();
		}
		
		
		int maxNumOfFood = 0; // 얻을 수 있는 식량의 최대값 
		for(int i = N-1; i >= 0; i--) {
			result[i] += numOfFood[i];
			
			int original = result[i];
			for(int j = i + 2; j < N; j++) {
				int afterAdd = original + result[j];
				if(afterAdd > result[i]) {
					result[i] = afterAdd;
				}
			}
			
			if(result[i] > maxNumOfFood) {
				maxNumOfFood = result[i];
			}
		}
		
		System.out.println(maxNumOfFood);
	}

}