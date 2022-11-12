import java.util.*;
import java.io.*;

public class Main9466B {

  static int n;
  static int[] stu = new int[100001];
  static int[] state = new int[100001];

  static StringBuilder ans = new StringBuilder();

  static int NOT_VISITED = 0;
  static int VISITED = 1;
  static int CYCLE_IN = 2;
  static int NOT_CYCLE_IN = 3;

  public static void run(int x) { // 학생 x를 시작으로 탐색 수행
    int cur = x;
    while (true) { // O(N)
      state[cur] = VISITED;
      cur = stu[cur];
      // case 1
      if (state[cur] == CYCLE_IN || state[cur] == NOT_CYCLE_IN) {
        cur = x;
        while (state[cur] == VISITED) { // O(N + N) => O(N), 해당 코드는 N번의 수행 중 1번의 경우에 대해 N번 수행되는 것임 (이중 for문이랑 다름)
          state[cur] = NOT_CYCLE_IN;
          cur = stu[cur];
        }
        return;
      }
      // case 2
      if (state[cur] == VISITED && cur != x) {
        while (state[cur] != CYCLE_IN) {
          state[cur] = CYCLE_IN;
          cur = stu[cur];
        }
        cur = x;
        while (state[cur] != CYCLE_IN) {
          state[cur] = NOT_CYCLE_IN;
          cur = stu[cur];
        }
        return;
      }
      // case 3
      if (state[cur] == VISITED && cur == x) {
        while (state[cur] != CYCLE_IN) {
          state[cur] = CYCLE_IN;
          cur = stu[cur];
        }
        return;
      }
    }
  }
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    while (T-- > 0) {
      n = Integer.parseInt(br.readLine());
      String[] str = br.readLine().split(" ");
      Arrays.fill(state, 1, n+1, 0); // 배열 영역 초기화
      for (int i = 1; i <= n; i++)
        stu[i] = Integer.parseInt(str[i - 1]);

      for (int i = 1; i <= n; i++) {
        if (state[i] == NOT_VISITED) run(i);
      }
      int cnt = 0;
      for (int i = 1; i <= n; i++) {
        if (state[i] == NOT_CYCLE_IN) cnt += 1;
      }
      ans.append(cnt).append('\n');
    }

    System.out.println(ans);
  }
}

/* 문제 회고

시간복잡도 O(N)으로 개선함

run()의 내부 구현
- 주어진 배열만 가지고 처리 수행함
- 탐색 시 방문한 학생에 대해 사이클에 포함 / 미포함 표시를 해줌

*/
