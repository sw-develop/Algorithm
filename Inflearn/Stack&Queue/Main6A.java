import java.util.*;

public class Main6A {

  public static int solution(int N, int K) {
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 1; i <= N; i++)
      queue.offer(i);

    int cnt = 0;
    while (queue.size() > 1) {
      cnt++;
      if (cnt == K) {
        queue.poll();
        cnt = 0;
      } else {
        int tmp = queue.poll();
        queue.offer(tmp);
      }
    }
    return queue.poll();
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    int N = kbd.nextInt();
    int K = kbd.nextInt();
    System.out.println(solution(N, K));
  }
}