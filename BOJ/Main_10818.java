import java.util.Scanner;

public class Main_10818 {
  public static void main(String[] args){
    Scanner kbd = new Scanner(System.in);

    int count = kbd.nextInt();

    //최대 최소 초기화
    int max = kbd.nextInt();
    int min = max;
    int val = 0;

    for(int i = 1; i<count; i++){
      val = kbd.nextInt();
      if(val > max) max = val;
      else if(val < min) min = val;
    }

    System.out.printf("%d %d", max, min);
  }
}