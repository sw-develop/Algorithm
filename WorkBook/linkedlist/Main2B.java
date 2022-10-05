import java.util.*;
import java.io.*;

public class Main2B {

  // 원형 연결리스트 저장을 위한 배열
  static int[] pre = new int[5001];
  static int[] nxt = new int[5001];

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] str = br.readLine().split(" ");
    int N = Integer.parseInt(str[0]);
    int K = Integer.parseInt(str[1]);

    // 원형 연결리스트 생성
    for (int i = 1; i <= N; i++) {
      if (i == 1) {
        pre[i] = N;
        nxt[i] = i + 1;
      } else if (i == N) {
        pre[i] = i - 1;
        nxt[i] = 1;
      } else {
        pre[i] = i - 1;
        nxt[i] = i + 1;
      }
    }

    // 리스트 순회 및 순열 생성
    StringBuilder sb = new StringBuilder();
    int cnt = 1;
    int len = N;
    for (int cur = 1; len != 0; cur = nxt[cur]) {
      if (cnt == K) {
        // 리스트에서 제거
        nxt[pre[cur]] = nxt[cur];
        pre[nxt[cur]] = pre[cur];
        len--;
        cnt = 1; // 초기화
        sb.append(cur);
        if (len != 0)
          sb.append(", ");
      } else {
        cnt++;
      }
    }

    // 순열 출력
    System.out.print("<");
    System.out.print(sb);
    System.out.print(">");
  }
}

/*
 * 문제 회고
 * 
 * 1) 연결리스트 구현
    1. 노드 객체 생성 후 연결
    2. 위와 같이 배열로 노드 연결 처리 (더 효율적)
 * 
 * 2) StringBuilder 활용하기
 * 
 * 3) static 변수 활용하기
 * 
 */