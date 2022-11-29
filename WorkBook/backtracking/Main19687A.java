import java.io.*;

public class Main19687A {

  static int N;
  static int[][] info;

  static int ans = 0;

  public static void solution(int k) { // k : k번째 계란
    // 재귀 종료
    if (k == N) {
      int tmp = 0; // 깨진 계란의 개수
      for (int i = 0; i < N; i++) {
        if (info[i][0] <= 0)
          tmp += 1;
      }
      ans = Math.max(ans, tmp);
      return;
    }
    // 재귀 수행
    if (info[k][0] <= 0) { // 손에 든 계란이 깨짐
      solution(k + 1);
      return;
    }
    boolean exist = false;
    for (int i = 0; i < N; i++) {
      if (i == k)
        continue;
      if (info[i][0] > 0) { // 깨지지 않은 다른 계란 존재함
        exist = true;
        info[k][0] -= info[i][1];
        info[i][0] -= info[k][1];
        solution(k + 1);
        info[k][0] += info[i][1];
        info[i][0] += info[k][1];
      }
    }
    if (!exist) // 깨지지 않은 다른 계란이 없음
      solution(k + 1);
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
