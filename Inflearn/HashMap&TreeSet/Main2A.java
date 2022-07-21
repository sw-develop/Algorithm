import java.util.*;

public class Main2A {

  public static String solution(String inputA, String inputB) {
    Map<Character, Integer> mapA = new HashMap<>();
    for (char c : inputA.toCharArray()) {
      mapA.put(c, mapA.getOrDefault(c, 0) + 1);
    }
    for (char c : inputB.toCharArray()) {
      if (!mapA.containsKey(c) || mapA.get(c) == 0) return "NO";
      mapA.put(c, mapA.get(c) - 1);
    }
    return "YES";
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    String inputA = kbd.next();
    String inputB = kbd.next();
    System.out.println(solution(inputA, inputB));
  }
}