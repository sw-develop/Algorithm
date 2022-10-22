//처음으로 등장하는 반복되지 않은 문자
//문자 등장 횟수 - Map (key - 문자, value - 등장 횟수)
//문자 등장 순서 - 문자 다시 돌면서 Map에서 조회해 등장 횟수가 1인 값 반환

//반복되지 않는 문자가 없는 경우에는?

import java.util.*;

public class Main1A {

  public static char solution(String str) {
    Map<Character, Integer> hm = new HashMap<>();
    for (char c : str.toCharArray()) {
      int cnt = hm.getOrDefault(c, 0);
      if (cnt > 0)
        hm.put(c, cnt + 1);
      else
        hm.put(c, 1);
    }

    char output = ' ';
    for (char c : str.toCharArray()) {
      if (hm.get(c) == 1) {
        output = c;
        break;
      }
    }

    return output;
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);

    String input = kbd.nextLine();
    System.out.println(solution(input));
  }
}