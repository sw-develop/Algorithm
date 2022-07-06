import java.util.Scanner;

public class Main7_2 {

  public static String solution(String input) {
    String tmp = new StringBuilder(input).reverse().toString();
    if (input.equalsIgnoreCase(tmp)) return "YES";
    return "NO";
  }
  
  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    String input = kbd.next();
    System.out.println(solution(input));
  }
}