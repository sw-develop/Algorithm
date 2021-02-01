//정수 1개 입력받아 3번 출력하기

import java.util.Scanner;

class main_1017{
  public static void main(String[] args){
      Scanner kbd = new Scanner(System.in);
      
      int val = kbd.nextInt();
      
      System.out.printf("%d %d %d", val, val, val);

      kbd.close();
  }
}