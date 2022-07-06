import java.util.*;

public class Main6_1 {

  public static String solution(String input) {
    char[] charArr = input.toCharArray();
    Set<Character> set = new HashSet<>();
    StringBuilder sb = new StringBuilder();
    for (char c : charArr) {
      if (!set.contains(c)) {
        set.add(c);
        sb.append(c);
      }
    }    
    return sb.toString();
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    String input = kbd.next();
    System.out.println(solution(input));
  }
}