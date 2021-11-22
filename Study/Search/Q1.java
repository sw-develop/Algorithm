import java.util.Arrays;
import java.util.Scanner;

public class Q1 {	
	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		
		int numOfExist = kbd.nextInt();	// 존재하는 부품의 개수 
		int[] exist = new int[numOfExist];	// 존재하는 부품 번호 
		
		for(int i = 0; i < numOfExist; i++) {
			exist[i] = kbd.nextInt();
		}
		
		int numOfWant = kbd.nextInt();	// 요청 부품 개수 
		int[] want = new int[numOfWant];	// 요청 부품 번호 
		
		for(int i = 0; i < numOfWant; i++) {
			want[i] = kbd.nextInt();
		}
		
		Arrays.sort(exist);	// Sorting 
		
		for(int i = 0; i < numOfWant; i++) {
			int check = Arrays.binarySearch(exist, want[i]);	// exist: array to be searched, want[i]: value to be searched for 
			
			if(check >= 0) // 존재할 때 
				System.out.print("yes ");
			else	
				System.out.print("no ");
		}
	}
}