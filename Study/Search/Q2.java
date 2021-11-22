import java.util.Scanner;

// 주제 : 이진 탐색 & 파라메트릭 서치
// 원하는 조건을 만족하는 가장 알맞은 값을 찾는 문제 

public class Q2 {
	public static void main(String[] args) {
		Scanner kbd 			          = new Scanner(System.in);
		
		int numOfRiceCake 		      = kbd.nextInt();	// 떡의 개수 
		int wantedLengthOfRiceCake  = kbd.nextInt();	// 요청한 떡의 길이 
		
		int[] arrOfRiceCake 	      = new int[numOfRiceCake];
		int maxLength 			        = 0;
		for(int i = 0; i < numOfRiceCake; i++) {
			arrOfRiceCake[i]          = kbd.nextInt();
			
			if(arrOfRiceCake[i] > maxLength) {	// 주어진 떡 길이의 최대값 찾기 
				maxLength               = arrOfRiceCake[i];	
			}
		}
		
		
		// 반복문 사용하여 이진탐색 구현
		int result 					      = 0;	// 절단기 높이 최댓값 (구하는 값) 
		int minLength 				    = 0;
		while(minLength <= maxLength) {
			int cuttedTotalLength 	= 0;	// 절단된 떡의 길이 총합 
			int midLength 			    = (maxLength + minLength) / 2;	// 절단기 높이 값 
			
			for(int i = 0; i < numOfRiceCake; i++) {	// 절단 떡의 길이 총합 계산 
				if(arrOfRiceCake[i] > midLength) {
					cuttedTotalLength += (arrOfRiceCake[i] - midLength);
				}
			}
			
			if(cuttedTotalLength >= wantedLengthOfRiceCake) {	// 자른 떡의 길이가 원하는 길이보다 크거나 같은 경우 (오른쪽 부분 탐색) - 더 긴 절단기 높이를 찾아야 함(높이의 최댓값을 찾기 위해서) 
				result 				        = midLength;	// 요청한 떡의 길이 이상이어야 하는 조건은 만족하므로 저장해둠 
				minLength 			      = midLength + 1;
			}
			else if(cuttedTotalLength < wantedLengthOfRiceCake) {		// 자른 떡의 길이가 원하는 길이보다 작은 경우 (왼쪽 부분 탐색) - 더 짧은 절단기 높이를 찾아야 함 
				maxLength 			      = midLength - 1;
			}
		}
			
		System.out.println(result);	// 정답 출력 

	}

}