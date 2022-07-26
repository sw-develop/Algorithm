import java.util.*;

public class Main4A {

  public static int solution(String input) {
    Stack<Integer> stack = new Stack<>();
    for (char c : input.toCharArray()) {
      if (c == '+' || c == '-' || c == '*' || c == '/') {
        int n1 = stack.pop();
        int n2 = stack.pop();
        if (c == '+')
          stack.push(n2 + n1);
        else if (c == '-')
          stack.push(n2 - n1);
        else if (c == '*')
          stack.push(n2 * n1);
        else
          stack.push(n2 / n1);
      } else {
        stack.push(Character.getNumericValue(c));
      }
    }
    return stack.pop();
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    String input = kbd.next();
    System.out.println(solution(input));
  }
}