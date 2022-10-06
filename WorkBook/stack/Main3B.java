/*
시간복잡도 : O(N)
*/

import java.util.*;
import java.io.*;

public class Main3B {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    StringTokenizer stt = new StringTokenizer(br.readLine());

    Stack<int[]> st = new Stack<>();
    StringBuilder ans = new StringBuilder();

    for (int i = 1; i <= N; i++) { // 탑 높이 입력 순서대로 진행
      int h = Integer.parseInt(stt.nextToken());
      while (!st.isEmpty()) {
        if (st.peek()[1] >= h) { // 현재 탑 높이보다 크거나 같을 때
          ans.append(st.peek()[0]);
          ans.append(" ");
          break;
        }
        st.pop(); // 현재 탑 높이보다 작을 때
      }
      if (st.isEmpty()) {
        ans.append("0 ");
      }
      st.push(new int[] { i, h });
    }

    System.out.println(ans);
  }
}


/*
 * 문제 회고
 * 
 * N의 범위에 따른 시간복잡도를 개선한 코드 떠올리기
 */