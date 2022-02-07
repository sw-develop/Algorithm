import java.util.Scanner;
import java.util.Arrays;

class Main{
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        
        int N = kbd.nextInt();
        
        int[] A = new int[N];
        int[] B = new int[N];
        
        for(int i = 0; i < N; i++) {
            A[i] = kbd.nextInt();
        }
        for(int i = 0; i < N; i++) {
            B[i] = kbd.nextInt();
        }
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int result = 0;
        for(int i = 0; i < N; i++) {
            result += A[i]*B[N-1-i];
        }
        
        System.out.println(result);

    }
}