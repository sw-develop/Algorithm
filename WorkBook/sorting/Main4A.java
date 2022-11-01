//BOJ 7795

import java.util.*;
import java.io.*;

public class Main4A {

  static StringBuilder ans = new StringBuilder();

  public static void solution(int N, int M, int[] A, int[] B) {
    // A와 B 오름차순 정렬
    Arrays.sort(A); // O(N^2)
    Arrays.sort(B);

    int pointerA = N - 1;
    int pointerB = M - 1;
    int cnt = 0;
    while (pointerB >= 0) {
      while (pointerA >= 0 && A[pointerA] > B[pointerB]) { // B의 값보다 A가 같거나 작을 때까지 A 인덱스 이동
        pointerA -= 1;
      }
      cnt += (N - 1 - pointerA);
      pointerB -= 1; // B 인덱스 이동
    }
    ans.append(cnt).append('\n');
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());
    StringTokenizer st;
    while (T-- > 0) {
      st = new StringTokenizer(br.readLine(), " ");
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());

      int[] A = new int[N];
      st = new StringTokenizer(br.readLine(), " ");
      for (int i = 0; i < N; i++)
        A[i] = Integer.parseInt(st.nextToken());

      int[] B = new int[M];
      st = new StringTokenizer(br.readLine(), " ");
      for (int i = 0; i < M; i++)
        B[i] = Integer.parseInt(st.nextToken());

      solution(N, M, A, B);
    }

    System.out.println(ans);

  }
}

/* 문제 회고

놓친 부분 
- 배열 정렬 
- 누적합

*/