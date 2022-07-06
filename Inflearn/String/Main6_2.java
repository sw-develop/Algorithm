import java.util.*;

public class Main6_2 {

  public static String solution(String input) {
    String ouput = "";
    for (int i = 0; i < input.length(); i++) {
      if (str.indexOf(str.charAt(i)) == i) output += str.charAt(i);
    }
    return output;
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    String input = kbd.next();
    System.out.println(solution(input));
  }
}