import java.util.*;
import java.io.*;

public class Main3B {

  public static List<StringBuilder> solution(int N, String[] input) {
    List<StringBuilder> output = new LinkedList<>();

    for (String str : input) {
      //스택2개 선언
      Stack<Character> s1 = new Stack<>();
      Stack<Character> s2 = new Stack<>();
      //수행
      char[] ch = str.toCharArray();
      for (char c : ch) {
        if (c == '-') {
          if (!s1.isEmpty()) s1.pop(); 
        }
        else if (c == '<') {
          if (!s1.isEmpty()) s2.push(s1.pop());
        }
        else if (c == '>') {
          if (!s2.isEmpty()) s1.push(s2.pop());
        }
        else {
          s1.push(c); 
        }
      }
      
      //결과 저장      
      while (!s1.isEmpty()) s2.push(s1.pop());
      StringBuilder answer = new StringBuilder();
      while (!s2.isEmpty()) answer.append(s2.pop());
      output.add(answer);
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
    for (StringBuilder str : solution(N, input)) bw.write(str + "\n");
    br.close();
    bw.close();
  }
}
