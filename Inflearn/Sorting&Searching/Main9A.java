import java.util.*;

public class Main9A {

  public static int count(int[] input, int capacity) {
    int cnt = 1; // DVD 개수
    int sum = 0;
    for (int i : input) {
      if (sum + i > capacity) {
        cnt++;
        sum = i;
      } else {
        sum += i;
      }
    }
    return cnt;
  }

  public static int solution(int N, int M, int[] input) {
    int lt = Arrays.stream(input).max().getAsInt();
    int rt = Arrays.stream(input).sum();

    int answer = 0;
    while (lt <= rt) {
      int mid = (lt + rt) / 2;
      if (count(input, mid) <= M) {
        answer = mid;
        rt = mid - 1;
      } else {
        lt = mid + 1;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    int N = kbd.nextInt();
    int M = kbd.nextInt();
    int[] input = new int[N];
    for (int i = 0; i < N; i++) {
      input[i] = kbd.nextInt();
    }
    System.out.println(solution(N, M, input));
  }
}