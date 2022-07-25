//6M30S

import java.util.*;

public class Main1A {

  public static String solution(String input) {
    Stack<Character> stack = new Stack<>();
    for (char c : input.toCharArray()) {
      if (c == '(') {
        stack.push(c);
      } else {
        if (stack.isEmpty())
          return "NO";
        stack.pop();
      }
    }
    if (!stack.isEmpty())
      return "NO";
    return "YES";
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    String input = kbd.next();
    System.out.println(solution(input));
  }
}