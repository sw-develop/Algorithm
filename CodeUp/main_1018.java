//시간 입력받아 그대로 출력하기
//입력) 6:13 출력) 6:13

import java.util.Scanner;
import java.util.StringTokenizer;

class main_1018{
  public static void main(String[] args){
    
      Scanner kbd = new Scanner(System.in);
      
      //방법1) 문자열 그대로 출력하기
      /*
      String val = kbd.nextLine();
      
      System.out.println(val);
      */

      //방법2) StringTokenizer 사용하기
      String val = kbd.nextLine();

      StringTokenizer st = new StringTokenizer(val, ":"); 
      String a = st.nextToken();
      String b = st.nextToken();
      
      System.out.printf("%s:%s", a, b);
    
      kbd.close();
    
  }
}