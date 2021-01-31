//실수 입력 받아 둘째 자리까지 출력하기 
import java.util.Scanner;

class main_1015{
  public static void main(String[] args){
      Scanner kbd = new Scanner(System.in);
      
      double val = kbd.nextDouble();
      
      System.out.printf("%.2f", val);

      
      kbd.close();
  }
}