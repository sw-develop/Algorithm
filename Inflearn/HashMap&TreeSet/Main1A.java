import java.util.*;

public class Main1A {
  
  public static Character solution(String input) {
    char output = ' ';
    Map<Character, Integer> map = new HashMap<>();
    for (char c : input.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    int max = Integer.MIN_VALUE;
    for (char c : map.keySet()) {
      if (map.get(c) > max) {
        max = map.get(c);
        output = c;
      }
    }
    return output;
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    int N = kbd.nextInt();
    String input = kbd.next();
    System.out.println(solution(input));
  }
}