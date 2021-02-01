//년, 월, 일 입력받아 지정된 형식으로 출력하기
//입력) 2013.6.13 출력)2013.06.13

import java.util.Scanner;
import java.util.StringTokenizer;

class main_1019{
  public static void main(String[] args){
      Scanner kbd = new Scanner(System.in);//Scanner 객체 선언

      StringTokenizer st = new StringTokenizer(kbd.nextLine(), "."); //문자열 입력 받고, . 을 기준으로 token으로 나누기

      System.out.printf("%04d.%02d.%02d", Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

      kbd.close();

     
  }
}