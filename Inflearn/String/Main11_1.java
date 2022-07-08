//문제를 잘 읽자 ^^

import java.util.*;

public class Main11_1 {

  public static String solution(String input) {
    String output = "";
    input += " ";
    int count = 1;
    for (int i = 0; i < input.length() - 1; i++) {
      if (input.charAt(i) == input.charAt(i+1)) count++;
      else {
        output += input.charAt(i);
        if (count > 1) output += String.valueOf(count);
        count = 1;
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