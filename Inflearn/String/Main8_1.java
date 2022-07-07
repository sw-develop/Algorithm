//18M

import java.util.*;

public class Main8_1 {

  public static String solution(String input) {
    input = input.replaceAll("[^a-zA-Z]", ""); //^ - 부정
    String reverse = new StringBuilder(input).reverse().toString();
    if (input.equalsIgnoreCase(reverse)) return "YES";
    else return "NO";
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    String input = kbd.nextLine();
    System.out.println(solution(input));
  }
}