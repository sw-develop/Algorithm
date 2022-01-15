import java.io.*;
import java.util.*;

class Main {
    public static int gcd(int a, int b) {
        int n = a % b;
        while(n != 0) {
            a = b;
            b = n;
            n = a % b;
        }
        return b;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int small;
        int large;
        if(N < M) {
            small = N;
            large = M;
        }
        else {
            small = M;
            large = N;
        }
        
       int gcd = gcd(large, small); // 최대 공약수       
       int lcm = N * M / gcd; // 최소 공배수
        
        System.out.print(gcd + "\n" + lcm);
    }
}