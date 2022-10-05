import java.util.*;
import java.io.*;

public class Main2A {

  static int[] pre = new int[5001];
  static int[] nxt = new int[5001];

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] str = br.readLine().split(" ");
    int N = Integer.parseInt(str[0]);
    int K = Integer.parseInt(str[1]);

    // 원형 연결 리스트 생성
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

    // 연결 리스트 순회하며 순열 생성
    int cnt = 1;
    int len = N;
    StringBuilder sb = new StringBuilder();
    for (int cur = 1; len != 0; cur = nxt[cur]) {
      // K번째일 때 제거
      if (cnt == K) {
        pre[nxt[cur]] = pre[cur];
        nxt[pre[cur]] = nxt[cur];
        cnt = 1;
        len--;
        sb.append(cur);
        if (len != 0)
          sb.append(", ");
      } else {
        cnt++;
      }
    }

    // 요세푸스 순열 출력
    System.out.print("<");
    System.out.print(sb);
    System.out.print(">");
  }
}