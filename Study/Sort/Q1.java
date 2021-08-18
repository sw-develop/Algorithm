import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner kbd = new Scanner(System.in);
		
		int N = kbd.nextInt();
		
		List<Integer> arr = new ArrayList<>(); // List 선언 및 생성 
		
		for(int i = 0; i < N; i++) {
			arr.add(kbd.nextInt()); 
		}
		
		Collections.sort(arr, Collections.reverseOrder());
		
		for(int i = 0; i < N; i++)
			System.out.print(arr.get(i) + " ");
		
		kbd.close();
	}

}