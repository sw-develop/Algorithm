import java.util.*;
import java.io.*;

public class Main4A {

  static int N;
  static char[][] input;
  static StringBuilder ans = new StringBuilder();

  public static boolean check(int rowS, int rowE, int colS, int colE) {
    char c = input[rowS][colS];
    for (int i = rowS; i <= rowE; i++) {
      for (int j = colS; j <= colE; j++) {
        if (input[i][j] != c) return false;
      }
    }
    if (c == '1') ans.append('1');
    else ans.append('0');
    return true;
  }
  
  public static void solution(int rowS, int rowE, int colS, int colE) {   
    //재귀 종료
    //모두 같은 숫자로 구성된 경우
    if (check(rowS, rowE, colS, colE)) return;  
    
    //재귀 수행
    //왼쪽 위, 오른쪽 위, 왼쪽 아래, 오른쪽 아래 순서로 분리되어 재귀 수행
    ans.append('(');
    int gap = (rowE - rowS + 1) / 2;
    for (int i = 0; i < 2; i++) {
      int rS = rowS + i * gap;
      for (int j = 0; j < 2; j++) {
        int cS = colS + j * gap;
        solution(rS, rS + gap - 1, cS, cS + gap - 1);
      }
    }
    ans.append(')');
  }
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    input = new char[N][N];
    for (int i = 0; i < N; i++) {
      String tmp = br.readLine();
      for (int j = 0; j < N; j++) {
        input[i][j] = tmp.charAt(j);
      }
    }
    solution(0, N-1, 0, N-1);
    System.out.println(ans);
  }
}