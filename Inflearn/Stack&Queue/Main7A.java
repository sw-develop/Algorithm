import java.util.*;

public class Main7A {

  public static String solution(String order, String input) {
    Queue<Character> queue = new LinkedList<>();
    for (char c : order.toCharArray())
      queue.offer(c);
    for (char c : input.toCharArray()) {
      if (queue.contains(c)) {
        if (queue.peek() == c)
          queue.poll();
        else
          return "NO";
      }
    }
    if (!queue.isEmpty())
      return "NO";
    return "YES";
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    String order = kbd.nextLine();
    String input = kbd.nextLine();
    System.out.println(solution(order, input));
  }
}