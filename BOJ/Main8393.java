import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        
        int n = kbd.nextInt();
        
        int result = 0;
        for(int i = 1; i <= n; i++) {
            result += i;
        }
        
        System.out.println(result);
    }
}