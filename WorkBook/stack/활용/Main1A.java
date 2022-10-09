//좋은 단어
//선끼리 교차 X
//각 글자를 정확히 한 개의 다른 위치에 있는 같은 글자와 짝 지어야 함

import java.util.*;
import java.io.*;

public class Main1A {

  static int ans = 0;

  public static void check(String str) {
    Stack<Character> st = new Stack<>();
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if (st.isEmpty()) st.push(c);
      else {
        if (st.peek() == c) st.pop();
        else st.push(c);
      }
    }
    if (st.isEmpty()) ans++;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    while (N-- > 0) {
      check(br.readLine());
    }

    System.out.println(ans);
  }
}

