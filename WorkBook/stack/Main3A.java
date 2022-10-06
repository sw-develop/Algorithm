import java.util.*;
import java.io.*;

public class Main3A {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    StringTokenizer stt = new StringTokenizer(br.readLine());

    Stack<int[]> st = new Stack<>(); // 탑의 idx, 탑의 높이
    StringBuilder ans = new StringBuilder();

    for (int i = 1; i <= N; i++) {
      int v = Integer.parseInt(stt.nextToken());
      while (!st.isEmpty()) {
        if (st.peek()[1] >= v) {
          ans.append(st.peek()[0]);
          ans.append(" ");
          break;
        }
        st.pop();
      }
      if (st.isEmpty()) {
        ans.append("0 ");
      }
      st.push(new int[] { i, v });
    }

    System.out.println(ans);
  }
}