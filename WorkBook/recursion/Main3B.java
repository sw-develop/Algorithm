//BOJ 2630

import java.util.*;
import java.io.*;

public class Main3B {

  static int N;
  static int[][] paper;
  static int[] cnt = new int[2]; //0 - white, 1 - blue

  public static boolean check(int x, int y, int n) {
    for (int i = x; i < x + n; i++) {
      for (int j = y; j < y + n; j++) {
        if (paper[i][j] != paper[x][y]) return false;
      }
    }
    return true;
  }

  public static void solution(int x, int y, int l) {
    //재귀 종료
    //모두 같은 색일 때
    if (check(x, y, l)) {
      cnt[paper[x][y]] += 1;
      return;
    }
    
    //재귀 수행
    //4개의 종이로 분리해 재귀 수행
    int n = l / 2;
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 2; j++) {
        solution(x + i * n, y + j * n, n);
      }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    paper = new int[N][N];
    StringTokenizer st;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < N; j++) {
        paper[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    solution(0, 0, N);
    for (int i = 0; i < cnt.length; i++) System.out.println(cnt[i]);
  }
}