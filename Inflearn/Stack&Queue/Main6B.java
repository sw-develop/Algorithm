import java.util.*;

public class Main6B {

  public static int solution(int N, int K) {
    int output = 0;
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 1; i <= N; i++)
      queue.offer(i);
    //불필요한 변수를 줄임
    while(!queue.isEmpty()) {
      for (int i = 1; i < K; i++) queue.offer(queue.poll());
      queue.poll();
      if (queue.size() == 1) output = queue.poll();
    }
    return output;
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    int N = kbd.nextInt();
    int K = kbd.nextInt();
    System.out.println(solution(N, K));
  }
}