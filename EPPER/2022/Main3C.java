import java.util.*;
import java.io.*;

public class Main3C {

  public static StringBuilder answer(Stack<Character> left, Stack<Character> right) {
    while (!left.isEmpty()) {
      right.push(left.pop());
    }
    StringBuilder sb = new StringBuilder();
    while (!right.isEmpty()) {
      sb.append(right.pop());
    }
    return sb;
  }

  public static StringBuilder findPassword(String str) {
    Stack<Character> left = new Stack<>();
    Stack<Character> right = new Stack<>();
    for (char c : str.toCharArray()) {
      if (c == '-') {
        if (!left.isEmpty()) left.pop();
      }
      else if (c == '<') {
        if (!left.isEmpty()) right.push(left.pop());
      }
      else if (c == '>') {
        if (!right.isEmpty()) left.push(right.pop());
      }
      else {
        left.push(c);
      }
    }
    return answer(left, right);
  }
  
  public static List<StringBuilder> solution(String[] input) {
    List<StringBuilder> output = new LinkedList<>();
    for (String str : input) {
      output.add(findPassword(str));
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
    
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for (StringBuilder str : solution(input)) bw.write(str + "\n");
    br.close();
    bw.close();
  }
}