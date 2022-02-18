import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        
        int N = kbd.nextInt();
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N-i; j++) System.out.print(" ");
            for(int k = 1; k <= i; k++) System.out.print("*");
            for(int m = 1; m <= i-1; m++) System.out.print("*");
            System.out.println();
        }
    }
}