//정수 2개 입력 받아 출력
import java.util.Scanner;

class main_1013{
  public static void main(String[] args){
      Scanner kbd = new Scanner(System.in);
      double a = kbd.nextInt();
      double b = kbd.nextInt();

      System.out.println(a + " " + b);

      kbd.close();
  }
}