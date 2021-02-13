//문제
//주어진 9개의 숫자 중에서 7개의 숫자의 합이 100이 되는 수를 찾아내기 
//9개의 숫자들은 모두 1이상 99이하이며 빈칸으로 주어지며 이들 중 숫자가 반복되는 경우는 없고, 답은 항상 유일하다.
//입력) 1 2 3 4 5 6 7 8 79
//출력) 1 2 3 4 5 6 79 

//생각) 전체 합을 구한 뒤 2개 선택해서 전체-2개값 = 100인 것을 찾자

//오류 부분) 이중 for문 모두 탈출하려면 break를 2번 해주던지 or 라벨 지정해주기

import java.util.Scanner;

 public class Main {
 public static int[] solution(int[] numbers) { //9개 중 7개의 수를 배열에 저장
	 
	 int[] answer = new int[7]; 
	 int total=0, total_1 = 0, count=0, val=0;
	 int i=0,j=0; //j값 초기화!
	
   //모든 정수 합 구하기 
	 for(int k = 0; k < numbers.length; k++)
		 total += numbers[k];
	 
	 //이중 for문 -> 헤맨 이유) 이중for문 break 2번 해줘야함...
	 total_1 = total;
	 Loop1: //라벨 지정해서 한번에 이중for문 빠져나가기 
	 for(i=0; i<9; i++){
		 for(j = i+1; j<9; j++){
			 val = total-numbers[i]-numbers[j]; //2개값 빼기
			 if(val==100) break Loop1;
			 total = total_1; //초기화 
		 }
		 //if(val==100) break;
	 }
	 
	 for(int k = 0; k<9; k++){
		 if(k!=i && k!=j) {
			 answer[count] = numbers[k]; //return할 배열에 값 저장
			 count+=1;
		 }
	 }
	 return answer;
 }
	
	public static void main(String [] args){
		int [] numbers=new int[9];
		int r[];
		Scanner input= new Scanner(System.in);
		
		for (int i = 0; i < 9; i++) {
			numbers[i]=input.nextInt();
		}
	
	r = solution(numbers); 
	for (int i = 0; i < 7; i++) {
		System.out.printf("%d ", r[i]);
	}
		
		
	}
}