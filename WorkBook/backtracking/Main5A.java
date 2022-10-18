//BOJ 15655

import java.util.*;
import java.io.*;

public class Main5A {

  static int N, M;
  static int[] input;
  static int[] arr = new int[8];

  static StringBuilder ans = new StringBuilder();

  public static void solution(int cnt, int idx) {
    // 재귀 종료
    if (cnt == M) {
      for (int i = 0; i < M; i++)
        ans.append(arr[i]).append(' ');
      ans.append('\n');
      return;
    }

    // 재귀 수행
    // 고른 수열은 오름차순
    for (int i = idx; i < N; i++) {
      arr[cnt] = input[i];
      solution(cnt + 1, i + 1);
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    input = new int[N];
    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < N; i++)
      input[i] = Integer.parseInt(st.nextToken());
    Arrays.sort(input);

    solution(0, 0);
    System.out.println(ans);
  }
}