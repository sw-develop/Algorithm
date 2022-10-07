import java.util.*;
import java.io.*;

public class Main1A {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    Deque<Integer> dq = new LinkedList<>(); // Deque 사용
    StringBuilder ans = new StringBuilder();

    for (int i = 0; i < N; i++) {
      StringTokenizer command = new StringTokenizer(br.readLine());

      switch (command.nextToken()) {
        case "push":
          dq.offer(Integer.parseInt(command.nextTokne()));
          break;

        case "pop":
          if (!dq.isEmpty()) {
            ans.append(dq.poll());
          } else {
            ans.append("-1");
          }
          break;

        case "size":
          ans.append(dq.size());
          break;

        case "empty":
          if (dq.isEmpty())
            ans.append("1");
          else
            ans.append("0");
          break;

        case "front":
          if (!dq.isEmpty()) {
            ans.append(dq.getFirst());
          } else {
            ans.append("-1");
          }
          break;

        case "back":
          if (!dq.isEmpty()) {
            ans.append(dq.getLast());
          } else {
            ans.append("-1");
          }
          break;

        default:
          break;
      }
    }
    System.out.println(ans);
  }
}