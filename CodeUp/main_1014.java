//문자(아스키 코드) 2개 입력 받아 순서 바꿔 출력
//개념) next() 함수는 띄어쓰기(공백) 기준으로 입력받음 
import java.util.Scanner;

class main_1014{
  public static void main(String[] args){
      Scanner kbd = new Scanner(System.in);
      
      /* 방법1) 문자열로 입력 받아 출력하기 
      String a = kbd.next();
      String b= kbd.next();
      */

      //방법2) 문자로 형변환하여 출력하기 
      char a = kbd.next().charAt(0);
      char b = kbd.next().charAt(0);
      System.out.printf("%c %c", b, a);

      
      kbd.close();
  }
}