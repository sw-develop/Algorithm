import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        
        int N = kbd.nextInt();
        
        int sum = 0;
        int num = 0;
        int val;
        for(int i = 0; i < N; i++) {
            val = kbd.nextInt();
            if(val != 1) {
                sum += val;
                num++;
            }
        }

        System.out.println(sum-(num-1));
    }
}