import java.util.*;
import java.io.*;

public class Main9466C {

  static int n;
  static int[] stu = new int[100001];
  static int[] state = new int[100001];

  static StringBuilder ans = new StringBuilder();

  static int NOT_VISITED = 0;
  static int CYCLE_IN = -1;

  public static void run(int x) { // 학생 x를 시작으로 탐색 수행
    int cur = x;
    while (true) { // O(N)
      state[cur] = x; // 방문 표시를 위해 현재 탐색의 시작 값을 저장
      cur = stu[cur];
      // case1 : 이번 탐색 시 방문한 학생에 도달했을 경우
      if (state[cur] == x) {
        while (state[cur] != CYCLE_IN) {
          state[cur] = CYCLE_IN;
          cur = stu[cur];
        }
        return;
      }
      // case2 : 이전 탐색 시 방문한 학생에 도달했을 경우
      else if (state[cur] != 0)
        return;
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
        if (state[i] != CYCLE_IN) cnt += 1;
      }
      ans.append(cnt).append('\n');
    }

    System.out.println(ans);
  }
}

/* 문제 회고

시간복잡도 O(N)으로 개선함

run()의 내부 구현
- '방문 표시를 위해 현재 탐색의 시작 값을 저장' 방식으로 if문 케이스를 줄임
- 방문 표시를 해당 방식으로 처리하면 O(N)으로 처리 가능함

*/