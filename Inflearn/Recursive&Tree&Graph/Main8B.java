import java.util.*;

public class Main8B {

  public static int[] check = new int[10001];
  public static int[] distance = {1, -1, 5};

  public static int solution(int S, int E) {
    Queue<Integer> q = new LinkedList<>();
    q.offer(S);
    check[S] = 1;
    int L = 0;
    while (!q.isEmpty()) {
      int len = q.size();
      for (int i = 0; i < len; i++) {
        int x = q.poll();
        for (int j = 0; j < 3; j++) {
          int nx = x + distance[j];
          if (nx == E) return L + 1;
          if (1 <= nx && nx <= 10000 && check[nx] == 0) {
            check[nx] = 1;
            q.offer(nx);
          }
        }
      }
      L++;
     }
    return L;
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    int S = kbd.nextInt();
    int E = kbd.nextInt();
    System.out.println(solution(S, E));
  }
}