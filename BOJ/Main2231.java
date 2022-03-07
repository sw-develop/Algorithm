import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        
        int N = kbd.nextInt();
        int result = 0;
        
        for(int i = 1; i <= N; i++) {
            int number = i;
            int sum = 0; //각 자릿수 합 변수 
            
            while(number != 0) {
                sum += number % 10; //각 자릿수 더하기
                number /= 10;
            }
            
            if(sum + i == N) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}