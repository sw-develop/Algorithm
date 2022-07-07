import java.util.*;

public class Main10_1 {

  public static int[] solution(String s, char t) {
    int[] distance = new int[s.length()];
    int p = 1000;
    for (int i = 0; i < s.length(); i++) { //왼쪽 -> 오른쪽
      if (s.charAt(i) == t) p = 0;
      else p++;
      distance[i] = p;
    }
    for (int i = distance.length - 1; i > 0; i--) { //오른쪽 -> 왼쪽
      distance[i-1] = Math.min(distance[i-1], distance[i] + 1);
    }
    return distance;
  }
  
  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    String s = kbd.next();
    char t = kbd.next().charAt(0);
    for (int i : solution(s, t)) {
      System.out.printf("%d ", i);
    }
  }
}