//문제) 노트북이 하루에 1개씩 판매됩니다. 현재 N개의 노트북을 가지고 있고, M일에 한번씩 노트북이 1개씩 입고됩니다. 노트북의 재고가 0이 될 때까지 며칠이 걸리는지 return하는 solution함수를 완성하세요. 단 재고가 0이 될 때, 도매점으로부터 입고되는 날이면 재고가 다시 1개 늘어납니다. 

import java.util.Scanner;

public class Main{
	public static int solution(int n, int m){
		//이 아래 필요한 변수 및 필요한 코드를 작성하세요
		int answer=0;
		
		while(true){
			if(n==0) break;
			n -=1; //노트북 판매
			answer +=1; //날짜 증가
			if(answer%m==0) n+=1; //m의 배수일 때(ex: 3,6,9, ..)
		}
		
		
		return answer;
	}


   public static void main(String[] args) {
      Scanner scanner=new Scanner(System.in);
      int n=scanner.nextInt();
      int m= scanner.nextInt();
      int answer=solution(n,m);
		 
      System.out.println(answer);
   }

}