//백준 15652

import java.util.*;
import java.io.*;

public class Main3A {

  static int N, M;

  static StringBuilder ans = new StringBuilder();
  static int[] arr;

  public static void solution(int cnt, int num) {
    //재귀 종료
    if (cnt == M) {
      //출력 값 처리
      for (int i = 0; i < M; i++)
        ans.append(arr[i]).append(' ');
      ans.append('\n');
      return;
    }
    
    //재귀 수행
    for (int i = num; i <= N; i++) {
      arr[cnt] = i;
      solution(cnt+1, i);
    }
  }
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    arr = new int[M];
    solution(0, 1);
    System.out.println(ans);
  }
}