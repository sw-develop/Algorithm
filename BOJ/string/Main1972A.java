import java.util.*;
import java.io.*;

public class Main1972A {

  public static boolean validate(String s, int D) { // D-유일한지 체크
    int gap = D + 1; // 문자간 간격

    HashSet<String> hs = new HashSet<>();
    for (int i = 0; i + gap < s.length(); i++) {
      String tmp = "";
      tmp += s.charAt(i);
      tmp += s.charAt(i + gap);

      if (!hs.add(tmp))
        return false;
    }
    return true;
  }

  public static List<String> solution(List<String> input) {
    List<String> output = new LinkedList<>();

    for (String s : input) {
      boolean check = true;
      for (int D = 0; D <= s.length() - 2; D++) {
        if (!validate(s, D)) { // D-유일하지 않을 때
          check = false;
          break;
        }
      }
      if (!check) {
        output.add(s + " is NOT surprising.");
      } else {
        output.add(s + " is surprising.");
      }
    }

    return output;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    List<String> input = new LinkedList<>();
    while (true) {
      String tmp = br.readLine();
      if (tmp.equals("*"))
        break;
      input.add(tmp);
    }

    for (String s : solution(input)) {
      System.out.println(s);
    }
  }
}