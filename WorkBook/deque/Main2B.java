import java.util.*;
import java.io.*;

public class Main2B {

  public static StringBuilder solution(String p, int n, Deque<Integer> d) {
    StringBuilder ans = new StringBuilder();

    boolean rev = false; // 뒤집기 판별

    for (int i = 0; i < p.length(); i++) {
      char func = p.charAt(i);
      if (func == 'R') { // 뒤집기 함수
        rev = !rev;
      } else { // 버리기 함수
        if (d.isEmpty()) {
          return new StringBuilder("error");
        }
        if (!rev)
          d.pollFirst();
        else
          d.pollLast();
      }
    }

    ans.append('[');
    while (!d.isEmpty()) {
      if (!rev) ans.append(d.pollFirst());
      else ans.append(d.pollLast());
      if (d.size() > 0) ans.append(',');
    }
    ans.append(']');

    return ans;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());
    List<StringBuilder> ans = new LinkedList<>();
    while (T-- > 0) {
      String p = br.readLine();
      int n = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine(), "[,]");
      Deque<Integer> d = new LinkedList<>();
      while (st.hasMoreTokens()) {
        d.offerLast(Integer.parseInt(st.nextToken()));
      }
      ans.add(solution(p, n, d));
    }

    for (StringBuilder sb : ans) {
      System.out.println(sb);
    }
  }
}

/*
문제 회고

변수 값의 크기 제한을 보고 시간복잡도도 함께 고려해야 함
*/