//백준 10799

import java.io.*;
import java.util.*;

public class Main2A {

  public static int solution(String input) {
    int ans = 0;

    Stack<Character> st = new Stack<>();
    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);
      if (c == '(') {
        st.push(c);
      } else {
        st.pop();
        if (input.charAt(i-1) == '(') ans += st.size();
        else ans += 1;
      }
    }
    
    return ans;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    System.out.println(solution(br.readLine()));
  }
}