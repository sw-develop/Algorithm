import java.util.*;
import java.io.*;

public class Main1A {

  static int N, M;
  static StringBuilder ans = new StringBuilder();

  public static void solution(int start, int[] arr, int idx) {
    // 재귀 종료
    if (idx == M) {
      for (int i = 0; i < M; i++) { // 출력값 처리
        if (i == M - 1)
          ans.append(arr[i]).append('\n');
        else
          ans.append(arr[i]).append(' ');
      }
      return;
    }
    if (start == N + 1)
      return;

    // 재귀 수행
    // 자기자신 이후부터 모두에 대해 재귀 수행
    for (int i = start + 1; i <= N; i++) {
      arr[idx] = i;
      solution(i, arr, idx + 1);
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    for (int i = 1; i <= N; i++) {
      int[] tmp = new int[M];
      tmp[0] = i;
      solution(i, tmp, 1);
    }
    System.out.println(ans);
  }
}
