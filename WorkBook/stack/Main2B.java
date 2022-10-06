import java.util.*;
import java.io.*;

public class Main2B {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    Stack<Integer> st = new Stack<>();
    int cnt = 1;
    StringBuilder ans = new StringBuilder();
    for (int i = 1; i <= n; i++) {
      int num = Integer.parseInt(br.readLine());
      while (cnt <= num) {
        st.push(cnt++);
        ans.append("+\n");
      }
      if (st.peek() != num) {
        System.out.println("NO");
        return;
      }
      st.pop();
      ans.append("-\n");
    }

    System.out.println(ans);
  }
}

/*
 * 문제 회고
 * 
StringBuilder 활용 
main메서드에서 반복문 끝낼 때 return; 활용
 * 
 */