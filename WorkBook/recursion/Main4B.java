import java.io.*;

public class Main4B {

  static char[][] input;
  static StringBuilder ans = new StringBuilder();

  public static boolean check(int x, int y, int n) {
    for (int i = x; i < x + n; i++) {
      for (int j = y; j < y + n; j++) {
        if (input[i][j] != input[x][y])
          return false;
      }
    }
    return true;
  }

  public static void solution(int x, int y, int l) {
    // 재귀 종료
    // 모두 같은 숫자로 구성된 경우
    if (check(x, y, l)) {
      if (input[x][y] == '1')
        ans.append('1');
      else
        ans.append('0');
      return;
    }

    // 재귀 수행
    // 왼쪽 위, 오른쪽 위, 왼쪽 아래, 오른쪽 아래 순서로 분리되어 재귀 수행
    ans.append('(');
    int n = l / 2;
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 2; j++) {
        solution(x + i * n, y + j * n, n);
      }
    }
    ans.append(')');
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    input = new char[N][N];
    for (int i = 0; i < N; i++) {
      String tmp = br.readLine();
      for (int j = 0; j < N; j++) {
        input[i][j] = tmp.charAt(j);
      }
    }
    solution(0, 0, N);
    System.out.println(ans);
  }
}