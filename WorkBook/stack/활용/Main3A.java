//백준 2504

import java.util.*;
import java.io.*;

public class Main3A {

  public static int solution(String input) {
    int ans = 0;
    int num = 1; //곱해질 값
    
    Stack<Character> st = new Stack<>();
    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);
      if (c == '(') {
        num *= 2;
        st.push(c);
      } else if (c == '[') {
        num *= 3;
        st.push(c);
      } else if (c == ')') {
        if (st.isEmpty() || st.peek() != '(') return 0;
        st.pop();
        if (input.charAt(i-1) == '(') ans += num;
        num /= 2;
      } else { // c == ']'
        if (st.isEmpty() || st.peek() != '[') return 0;
        st.pop();
        if (input.charAt(i-1) == '[') ans += num;
        num /= 3;
      }
    }
      
    if (!st.isEmpty()) return 0;
    return ans;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    System.out.println(solution(br.readLine()));
  }
}

/*
문제 회고

마지막에 빈 스택이 아닌 경우에 대한 예외 처리도 생각했어야 함
*/