import java.util.*;

public class Main12_1 {

  public static String solution(int n, String input) {
    String output = "";
    for (int i = 0; i < n; i++) {
      String tmp = input.substring(0, 7).replace('#', '1').replace('*', '0');
      int num = Integer.parseInt(tmp, 2);
      output += (char) num;
      input = input.substring(7);
    }
    return output;
  }
  
  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    int n = kbd.nextInt();
    String input = kbd.next();
    System.out.println(solution(n, input));
  }
}