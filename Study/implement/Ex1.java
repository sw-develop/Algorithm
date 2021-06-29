import java.util.Scanner;

class Ex1 {

	public static void main(String[] args) {
		//3, 13, 23 , 30~39, 43, 53
		
		Scanner kbd = new Scanner(System.in);
		
		int N = kbd.nextInt();
		
		int count = 0;
		
		for(int i = 0; i < N+1; i++)
			for(int k = 0; k < 60; k++)
				for(int j = 0; j < 60; j++) {
					//int -> String으로 변환
					String time = Integer.toString(i) + Integer.toString(k) + Integer.toString(j);
					//변환한 String에 3이 있으면 count 증가시키기 
					if(time.contains("3")) count++;
				}
		
		System.out.println(count);
					
	}

}
