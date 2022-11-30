import java.io.*;

public class Main19687B {

  static int N;
  static int[][] info;

  static int ans = 0;
  static int cnt = 0; // 깨진 계란의 수

  public static void solution(int k) { // k : k번째 계란
    // 재귀 종료
    if (k == N) {
      ans = Math.max(ans, cnt);
      return;
    }
    // 재귀 수행
    if (info[k][0] <= 0 || cnt == N-1) { // 손에 든 계란이 깨졌거나 깨지지 않은 다른 계란이 없음
      solution(k + 1);
      return;
    }
    for (int i = 0; i < N; i++) {
      if (i == k || info[i][0] <= 0)
        continue;
      info[k][0] -= info[i][1];
      info[i][0] -= info[k][1];
      if (info[k][0] <= 0) cnt++;
      if (info[i][0] <= 0) cnt++;
      solution(k + 1);
      if (info[k][0] <= 0) cnt--;
      if (info[i][0] <= 0) cnt--;
      info[k][0] += info[i][1];
      info[i][0] += info[k][1];
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    info = new int[N][2]; // 내구도, 무게
    for (int i = 0; i < N; i++) {
      String[] tmp = br.readLine().split(" ");
      info[i][0] = Integer.parseInt(tmp[0]); // 내구도
      info[i][1] = Integer.parseInt(tmp[1]); // 무게
    }

    solution(0);
    System.out.println(ans);
  }
}