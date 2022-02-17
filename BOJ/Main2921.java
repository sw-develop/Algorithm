import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        
        int N = kbd.nextInt();
        
        int sum = 0;
        for(int i = 0; i <= N; i++) sum += i;
        
        System.out.println(sum + sum*(N+1));
    }
}