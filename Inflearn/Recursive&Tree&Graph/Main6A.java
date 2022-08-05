// 부분집합 구하기 (DFS)

import java.util.*;

public class Main6A {

  static int N;
  static int[] ch;

  public static void subset(int L) {
    if (L == N + 1) {
      String tmp = "";
      for (int i = 1; i <= N; i++) {
        if (ch[i] == 1) // 부분집합에 포함되는 원소만
          tmp += (i + " ");
      }
      if (tmp.length() > 0) // 공집합 제외
        System.out.println(tmp);
    } else {
      ch[L] = 1; // 해당 원소가 부분집합에 포함
      subset(L + 1);
      ch[L] = 0; // 해당 원소가 부분집합에 포함 X
      subset(L + 1);
    }
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    N = kbd.nextInt();
    ch = new int[N + 1];
    subset(1);
  }
}