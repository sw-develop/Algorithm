import java.util.*;

class Main {
    static Long N;
    static int[] counts = new int[10];
    static String num;
    
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        
        N = kbd.nextLong();
        
        num = N.toString();
        
        for(int i = 0; i < num.length(); i++) {
            int index = Integer.parseInt(String.valueOf(num.charAt(i)));
            counts[index]++;
        }
        
        //6, 9 횟수 계산
        int sum = counts[6] + counts[9];
        int val = (sum % 2 == 0) ? sum / 2 : sum / 2 + 1;         
        counts[6] = val;
        counts[9] = 0;
        
        Arrays.sort(counts);
        System.out.println(counts[9]);
        
    }
}