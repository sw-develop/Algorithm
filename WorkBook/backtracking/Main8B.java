import java.util.*;
import java.io.*;

public class Main8B {

  static int N, M;
  static int[] input;
  static int[] arr = new int[8];
  static int[] isused = new int[8];

  static StringBuilder ans = new StringBuilder();

  public static void solution(int cnt) {
    //재귀 종료
    if (cnt == M) {
      for (int i = 0; i < M; i++)
        ans.append(arr[i]).append(' ');
      ans.append('\n');
    }
    
    //재귀 수행
    int tmp = 0;
    for (int i = 0; i < N; i++) {
      if (isused[i] == 0 && tmp != input[i]) {
        isused[i] = 1;
        arr[cnt] = input[i];
        tmp = arr[cnt];
        solution(cnt + 1);
        isused[i] = 0;
      }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    input = new int[N];
    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < N; i++)
      input[i] = Integer.parseInt(st.nextToken());
    Arrays.sort(input);

    solution(0);
    System.out.println(ans);
  }
}