import java.util.*;
import java.io.*;

public class Main1B {

  public static StringBuilder find(String s) {
    List<Character> list = new LinkedList<>();

    int cursor = -1;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);

      if (c == '-') {
        if (cursor != -1) {
          list.remove(cursor);
          cursor--;
        }
      } else if (c == '>') {
        if (cursor != list.size() - 1)
          cursor++;
      } else if (c == '<') {
        if (cursor != -1)
          cursor--;
      } else {
        list.add(cursor + 1, c);
        cursor++;
      }
    }

    StringBuilder sb = new StringBuilder();
    for (char c : list) {
      sb.append(c);
    }
    return sb;
  }

  public static List<StringBuilder> solution(String[] input) {
    List<StringBuilder> output = new LinkedList<>();

    for (String s : input) {
      output.add(find(s));
    }

    return output;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    String[] input = new String[N];
    for (int i = 0; i < N; i++) {
      input[i] = br.readLine();
    }

    for (StringBuilder sb : solution(input)) {
      System.out.println(sb);
    }
  }
}