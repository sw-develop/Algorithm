import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        
        int N = kbd.nextInt();
        
        String[] str = new String[N];
        for(int i = 0; i < N; i++) {
            str[i] = kbd.next();
        }
        
        if(N==1) {
            System.out.println(str[0]);
        }
        else {
            int lenOfFileName = str[0].length();
        
            String result = "";
            for(int i = 0; i < lenOfFileName; i++) {
                char ca = str[0].charAt(i);
                for(int j = 1; j < N; j++) {
                    char cb = str[j].charAt(i);
                    if(ca != cb) {
                        result += "?";
                        break;
                    }
                    if(j == N-1) {
                        result += Character.toString(ca);
                    }
                }
            }
            System.out.println(result);            
        }

    }
}