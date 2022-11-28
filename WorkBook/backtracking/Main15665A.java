import java.util.*;
import java.io.*;

public class Main15665A {

  static int N, M;
  static int[] input;
  static int[] arr;
  static StringBuilder sb = new StringBuilder();

  static void solution(int cnt) {
    //재귀 종료
    if (cnt == M) {
      for (int i = 0; i < M; i++) {
        sb.append(arr[i]).append(' ');
      }
      sb.append('\n');
      return;
    }
    //재귀 수행
    int tmp = 0;
    for (int i = 0; i < N; i++) {
      if (tmp != input[i]) { //중복수열 판별
        tmp = input[i];
        arr[cnt] = input[i];
        solution(cnt + 1);
      }
    }
  }
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] tmp = br.readLine().split(" ");
    N = Integer.parseInt(tmp[0]);
    M = Integer.parseInt(tmp[1]);

    input = new int[N];
    tmp = br.readLine().split(" ");
    for (int i = 0; i < N; i++) {
      input[i] = Integer.parseInt(tmp[i]);
    }

    Arrays.sort(input);
    arr = new int[M];
    solution(0);
    System.out.println(sb);
  }
}

/* 문제

조건
- 같은 수 여러 번 골라도 됨
- 중복되는 수열 출력 X
- 수열은 사전 순으로 증가하는 순서로 출력

*/