//문제 조건을 똑바로 읽자!

import java.util.*;

public class Main5A {

  public static int solution(String input) {
    int output = 0;

    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < input.length(); i++) {
      if (input.charAt(i) == '(')
        stack.push(input.charAt(i));
      else {
        stack.pop();
        if (input.charAt(i - 1) == '(')
          output += stack.size();
        else
          output += 1;
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