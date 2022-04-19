import java.util.*;

public class Main1003 {
    
    public static int[] arr1 = new int[41];    //0 횟수
    public static int[] arr2 = new int[41];    //1 횟수
     
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);

        int T = kbd.nextInt();  //테스트 케이스 개수
        
        int[] inputs = new int[T];
        for(int i = 0; i < T; i++) {
            inputs[i] = kbd.nextInt();
        }
        
        //배열 채우기
        arr1[0] = 1;
        arr2[0] = 0;
      
        arr1[1] = 0;
        arr2[1] = 1;
        
        for(int i = 2; i < 41; i++) {
            arr1[i] = arr1[i-1] + arr1[i-2];
            arr2[i] = arr2[i-1] + arr2[i-2];
        }

        for(int input : inputs) {
          System.out.printf("%d %d\n", arr1[input], arr2[input]);
        }
        
    }
}