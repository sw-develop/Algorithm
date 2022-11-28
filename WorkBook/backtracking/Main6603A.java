//0913-0925
//0925-0938

//모든 경우의 수 탐색 => 백트래킹
//주어진 입력 값 중복 사용 X
//중복수열 출력 X
//사전 순으로 출력

import java.io.*;

public class Main6603A {

  static StringBuilder sb = new StringBuilder();
  static int[] arr = new int[6];

  public static void solution(String[] input, int cnt, int idx) {
    // 재귀 종료
    if (cnt == 6) {
      for (int i = 0; i < 6; i++) {
        sb.append(arr[i]).append(' ');
      }
      sb.append('\n');
      return;
    }
    // 재귀 수행
    int tmp = 0;
    for (int i = idx; i <= Integer.parseInt(input[0]); i++) {
      int val = Integer.parseInt(input[i]);
      if (tmp != val) { // 중복수열 판별
        tmp = val;
        arr[cnt] = val;
        solution(input, cnt + 1, i + 1);
      }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] tmp = null;
    while (true) {
      tmp = br.readLine().split(" ");
      if (tmp[0].equals("0"))
        break;
      solution(tmp, 0, 1);
      sb.append('\n');
    }

    System.out.println(sb);
  }
}

/* 문제

조건
- 모든 경우의 수 탐색 => 백트래킹
- 주어진 입력 값 중복 사용 X
- 중복수열 출력 X
- 사전 순으로 출력
- 주어지는 입력 값은 오름차순 정렬되어 있음

*/