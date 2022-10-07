import java.util.*;
import java.io.*;

public class Main1A {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    Deque<Integer> dq = new LinkedList<>(); // Deque 사용
    StringBuilder ans = new StringBuilder();

    for (int i = 0; i < N; i++) {
      StringTokenizer command = new StringTokenizer(br.readLine(), " ");

      switch (command.nextToken()) {
        case "push":
          dq.offer(Integer.parseInt(command.nextToken()));
          break;

        case "pop":
          if (!dq.isEmpty()) {
            ans.append(dq.poll()).append('\n');
          } else {
            ans.append(-1).append('\n');
          }
          break;

        case "size":
          ans.append(dq.size()).append('\n');
          break;

        case "empty":
          if (dq.isEmpty())
            ans.append(1).append('\n');
          else
            ans.append(0).append('\n');
          break;

        case "front":
          if (!dq.isEmpty()) {
            ans.append(dq.getFirst()).append('\n');
          } else {
            ans.append(-1).append('\n');
          }
          break;

        case "back":
          if (!dq.isEmpty()) {
            ans.append(dq.getLast()).append('\n');
          } else {
            ans.append(-1).append('\n');
          }
          break;

        default:
          break;
      }
    }
    System.out.println(ans);
  }
}