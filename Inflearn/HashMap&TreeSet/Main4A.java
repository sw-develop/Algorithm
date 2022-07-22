import java.util.*;

public class Main4A {

  public static int solution(String S, String T) {
    int output = 0;

    Map<Character, Integer> mapS = new HashMap<>();
    Map<Character, Integer> mapT = new HashMap<>();

    for (char c : T.toCharArray()) mapT.put(c, mapT.getOrDefault(c, 0) + 1);

    int windowSize = T.length();
    for (int i = 0; i < windowSize; i++) {
      mapS.put(S.charAt(i), mapS.getOrDefault(S.charAt(i), 0) + 1);
    }
    if (mapS.equals(mapT)) output++;
    
    for (int i = windowSize; i < S.length(); i++) {
      mapS.put(S.charAt(i-windowSize), mapS.get(S.charAt(i-windowSize)) - 1);
      if (mapS.get(S.charAt(i-windowSize)) == 0) mapS.remove(S.charAt((i-windowSize)));

      mapS.put(S.charAt(i), mapS.getOrDefault(S.charAt(i), 0) + 1);

      if (mapS.equals(mapT)) output++;
    }
    
    return output;
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    String S = kbd.next();
    String T = kbd.next();
    System.out.println(solution(S, T));
  }
}