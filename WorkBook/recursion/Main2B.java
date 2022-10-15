import java.util.*;
import java.io.*;

public class Main2B {

  static int N;
  static int[][] paper;

  static int cnt[] = new int[3]; // -1, 0, 1로 채워진 종이 개수

  public static boolean check(int x, int y, int n) {
    for (int i = x; i < x + n; i++) {
      for (int j = y; j < y + n; j++) {
        if (paper[i][j] != paper[x][y]) return false;
      }
    }
    return true;
  }

  public static void solution(int x, int y, int l) {
    // 재귀 종료 조건
    // 종이가 모두 같은 수로 되어있을 때
    if (check(x, y, l)) {
      cnt[paper[x][y] + 1] += 1; //종이 개수 업데이트
      return;
    }

    // 재귀 수행
    // 종이를 같은 크기 9개로 자름, 9개의 종이에 대해 재귀 수행
    int n = l / 3; //종이 한 변의 길이 업데이트
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
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
    solution(0, 0, N); //종이 시작 위치 & 종이 한 변의 길이 전달
    for (int i = 0; i < cnt.length; i++) {
      System.out.println(cnt[i]);
    }
  }
}

/*

문제 회고

-1, 0, 1 각각으로 구성된 종이 개수 셀 때 배열 사용할 수 있음
재귀 함수의 인자로 종이 시작 위치(x, y) & 종이 한 변의 길이만 전달해 처리 가능함

*/