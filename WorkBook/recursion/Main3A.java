import java.util.*;
import java.io.*;

public class Main3A {

  static int N;
  static char[][] paper;
  static int blue = 0;
  static int white = 0;

  public static boolean check(int rowS, int rowE, int colS, int colE) {
    char c = paper[rowS][colS];
    for (int i = rowS; i <= rowE; i++) {
      for (int j = colS; j <= colE; j++) {
        if (paper[i][j] != c) return false;
      }
    }
    if (c == '0') white++;
    else blue++;
    return true;
  }

  public static void solution(int rowS, int rowE, int colS, int colE) {
    //재귀 종료
    //모두 같은 색일 때
    if (check(rowS, rowE, colS, colE)) return;
    
    //재귀 수행
    //4개의 종이로 분리해 재귀 수행
    int gap = (rowE - rowS + 1) / 2;
    for (int i = 0; i < 2; i++) {
      int rS = rowS + i * gap;
      for (int j = 0; j < 2; j++) {
        int cS = colS + j * gap;
        solution(rS, rS + gap - 1, cS, cS + gap - 1);
      }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    paper = new char[N][N];
    StringTokenizer st;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < N; j++) {
        paper[i][j] = st.nextToken().charAt(0);
      }
    }
    solution(0, N-1, 0, N-1);
    System.out.println(white + "\n" + blue);
  }
}