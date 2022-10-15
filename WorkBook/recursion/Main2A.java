import java.util.*;
import java.io.*;

public class Main2A {

  static int N;
  static int[][] paper;

  static int paperA = 0; //-1
  static int paperB = 0; //0
  static int paperC = 0; //1

  public static boolean check(int rowS, int rowE, int colS, int colE) {
    int c = paper[rowS][colS];
    for (int i = rowS; i <= rowE; i++) {
      for (int j = colS; j <= colE; j++) {
        if (paper[i][j] != c) return false;
      }
    }
    if (c == -1) paperA++;
    else if (c == 0) paperB++;
    else paperC++;
    return true;
  }
  
  public static void solution(int rowS, int rowE, int colS, int colE) {
    //재귀 종료
    //종이가 모두 같은 수로 되어있을 때
    if (check(rowS, rowE, colS, colE)) return;

    //재귀 수행
    //종이를 같은 크기 9개로 자름
    //9개에 대해 재귀 수행
    int gap = (rowE - rowS + 1) / 3;
    for (int i = 0; i < 3; i++) {
      int rS = rowS + i * gap;
      for (int j = 0; j < 3; j++) {
        int cS = colS + j * gap;
        solution(rS, rS + gap - 1, cS, cS + gap - 1);
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
    solution(0, N-1, 0, N-1);
    System.out.print(paperA + "\n" + paperB + "\n" + paperC);
  }
}