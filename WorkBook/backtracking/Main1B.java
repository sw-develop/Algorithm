import java.util.*;
import java.io.*;

public class Main1B {

  static int N, M;
  static StringBuilder ans = new StringBuilder();
  static int[] arr;

  public static void solution(int k) { // k - 선택한 숫자 개수
    if (k == M) {
      for (int i = 0; i < M; i++)
        ans.append(arr[i]).append(' ');
      ans.append('\n');
      return;
    }

    int st = 1; // 시작 숫자, k = 0일 때 st = 1
    if (k != 0)
      st = arr[k - 1] + 1;
    for (int i = st; i <= N; i++) {
      arr[k] = i;
      solution(k + 1);
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    arr = new int[M];
    solution(0);
    System.out.println(ans);
  }
}

/*
 * 
 * 문제 회고 

- dfs를 위한 상태트리 구상 
- dfs 기준을 '선택한 숫자 개수'로 설정할 수 있음
 * 
 */