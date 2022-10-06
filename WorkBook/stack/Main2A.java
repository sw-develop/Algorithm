import java.util.*;
import java.io.*;

public class Main2A {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    Stack<Integer> st = new Stack<>();
    int ch = 1; // 스택에 넣을 시작 값
    StringBuilder ans = new StringBuilder();
    boolean check = true;
    for (int i = 0; i < n; i++) {
      int num = Integer.parseInt(br.readLine());
      if (st.isEmpty() || st.peek() < num) {
        for (int j = ch; j <= num; j++) {
          st.push(j);
          ans.append('+');
        }
        ch = num + 1; // 업데이트
        st.pop();
        ans.append('-');
      } else if (!st.isEmpty() && st.peek() == num) {
        st.pop();
        ans.append('-');
      } else {
        check = false;
        System.out.println("NO");
        break;
      }
    }

    if (check) {
      for (int i = 0; i < ans.length(); i++) {
        System.out.println(ans.charAt(i));
      }
    }
  }
}