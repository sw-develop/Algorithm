import java.util.*;
import java.io.*;

public class Main2A {

  public static int solution(String input) {
    int answer = 0;

    char[] ch = input.toCharArray();
    Stack<Character> st = new Stack<>();

    for (int i = 0; i < ch.length; i++) {
      if (ch[i] == '(') {
        st.push(ch[i]);
      }
      else {
        st.pop();

        if (ch[i-1] == '(')
          answer += st.size();
        else
          answer += 1;
      }
    }
    
    return answer;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    System.out.println(solution(input));
  }
}