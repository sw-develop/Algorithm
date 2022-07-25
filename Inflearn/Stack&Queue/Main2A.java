import java.util.*;

public class Main2A {

  public static String solution(String input) {
    String output = "";
    Stack<Character> stack = new Stack<>();
    for (char c : input.toCharArray()) {
      if (c == '(') stack.push(c);
      else if (c == ')') stack.pop();
      else {
        if (stack.isEmpty()) output += c;
      }
    }
    return output;
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    String input = kbd.next();
    System.out.println(solution(input));
  }
} 