//백준 15654

import java.io.*;
import java.util.*;

public class Main4A {

  static int N, M;

  static StringBuilder ans = new StringBuilder();
  static int[] arr;
  static int[] input;
  static int[] check;

  public static void solution(int cnt) {
    // 재귀 종료
    if (cnt == M) {
      for (int i = 0; i < M; i++)
        ans.append(arr[i]).append(' ');
      ans.append('\n');
      return;
    }

    // 재귀 수행
    for (int i = 0; i < N; i++) {
      if (check[i] == 0) {
        check[i] = 1;
        arr[cnt] = input[i];
        solution(cnt + 1);
        check[i] = 0;
      }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    arr = new int[M];
    input = new int[N];
    check = new int[N];

    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < N; i++) {
      input[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(input); // 오름차순 정렬

    solution(0);
    System.out.println(ans);
  }
}