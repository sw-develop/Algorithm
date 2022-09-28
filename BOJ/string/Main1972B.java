 import  java.util.*;
import java.io.*;

public class Main1972B {

  public static boolean validate(String s) { //D-유일한지 체크
    for (int i = 1; i < s.length(); i++) { //i = 문자간 간격
      boolean[][] alphabet = new boolean[26][26];
      for (int j = 0; j + i < s.length(); j++) {
        if (alphabet[s.charAt(j)-'A'][s.charAt(j+i)-'A']) return false; //이미 존재하는 문자쌍일 때
        alphabet[s.charAt(j)-'A'][s.charAt(j+i)-'A'] = true;
      }
    }
    return true;
  }

  public static List<String> solution(List<String> input) {
    List<String> output = new LinkedList<>();

    for (String s : input) {
      if (!validate(s)) output.add(s + " is NOT surprising.");
      else output.add(s + " is surprising.");
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