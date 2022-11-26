import java.util.Arrays;
import java.io.*;

public class Main15664A {

  static int N, M;
  static int[] input;
  static int[] arr;
  static StringBuilder sb = new StringBuilder();

  public static void solution(int inputIdx, int arrIdx) {
    // 재귀 종료
    if (arrIdx == M) {
      for (int i = 0; i < M; i++) {
        sb.append(arr[i]).append(' ');
      }
      sb.append('\n');
      return;
    }
    // 재귀 수행
    int tmp = 0;
    for (int i = inputIdx; i < N; i++) { // 비내림차순 수열
      if (tmp != input[i]) { // 동일한 위치의 이전 수열의 항과 현재 수열의 항의 값이 같으면 중복 수열
        tmp = input[i];
        arr[arrIdx] = input[i];
        solution(i + 1, arrIdx + 1);
      }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] tmp = br.readLine().split(" ");
    N = Integer.parseInt(tmp[0]);
    M = Integer.parseInt(tmp[1]);
    input = new int[N];
    tmp = br.readLine().split(" ");
    for (int i = 0; i < tmp.length; i++) {
      input[i] = Integer.parseInt(tmp[i]);
    }

    Arrays.sort(input); // 오름차순 정렬
    arr = new int[M];
    solution(0, 0);
    System.out.println(sb);
  }
}