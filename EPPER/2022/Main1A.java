import java.io.*;
import java.util.Arrays;

class Main {
  public static double solution(int[] num_arr, int n) {
    double sol = 0;

    // 1.오름차순 정렬
    Arrays.sort(num_arr);

    // 2.처음 2개 평균값 구하기
    sol = (num_arr[0] + num_arr[1]) / (float) 2;

    // 3.나머지 차례대로 더해서 평균값 구하기
    for (int i = 2; i < n; i++) {
      sol = (sol + num_arr[i]) / (float) 2;
    }

    return sol;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine()); // 점수 개수 입력 변수
    int[] num_arr = new int[n]; // 점수 값 배열
    for (int i = 0; i < n; i++) {
      num_arr[i] = Integer.parseInt(br.readLine());
    }
    System.out.printf("%.6f", solution(num_arr, n));
  }
}