import java.util.*;
import java.io.*;

public class Main1A {

  public static StringBuilder find(String s) {
    StringBuilder sb = new StringBuilder();

    LinkedList<Character> left = new LinkedList<>();
    LinkedList<Character> right = new LinkedList<>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '-') {
        if (!left.isEmpty()) {
          left.removeLast();
        }
      } else if (c == '>') {
        if (!right.isEmpty()) {
          left.add(right.removeFirst());
        }
      } else if (c == '<') {
        if (!left.isEmpty()) {
          right.addFirst(left.removeLast());
        }
      } else {
        left.add(c);
      }
    }

    for (char c : left) {
      sb.append(c);
    }

    for (char c : right) {
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

/*
문제 회고

커서 기준 앞, 뒤를 각각 리스트로 처리

*/