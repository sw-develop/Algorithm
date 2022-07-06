import java.util.Scanner;

public class Main7_1 {

  public static String solution(String input) {
    String str = input.toLowerCase();
    for (int i = 0; i < str.length() / 2; i++) {
      if (str.charAt(i) != str.charAt(str.length() - 1 - i)) return "NO";
    }
    return "YES";
  }
  
  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    String input = kbd.next();
    System.out.println(solution(input));
  }
}