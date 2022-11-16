import java.util.Arrays;
import java.io.*;

public class Main9466D {

  static int n; //학생 수
  static int[] stu = new int[100001];
  static int[] state = new int[100001];
  static StringBuilder ans = new StringBuilder();

  static int NOT_VISITED = 0;
  static int CYCLE_IN = -1;

  public static void run(int x) {
    int cur = x;
    while (true) {
      state[cur] = x;
      cur = stu[cur];
      if (state[cur] == x) {
        while (state[cur] != CYCLE_IN) {
          state[cur] = CYCLE_IN;
          cur = stu[cur];
        }
        return;
      } else if (state[cur] != 0) {
        return;
      }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      n = Integer.parseInt(br.readLine());
      Arrays.fill(state, 1, n+1, 0); // 초기화
      
      String[] str = br.readLine().split(" ");
      for (int i = 1; i <= n; i++) {
        stu[i] = Integer.parseInt(str[i - 1]);
      }

      for (int i = 1; i <= n; i++) { // 각 학생의 팀 생성 여부 파악
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
