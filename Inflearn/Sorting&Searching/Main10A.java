import java.util.*;

public class Main10A {

  public static int count(int[] input, int distance) {
    int cnt = 1; //말을 놓을 수 있는 좌표의 개수
    int ep = input[0]; //첫 시작 값은 첫 좌표
    for (int i = 1; i < input.length; i++) {
      if (input[i] - ep >= distance) {
        cnt++;
        ep = input[i];
      }
    }
    return cnt;
  }
  
  public static int solution(int N, int C, int[] input) {
    Arrays.sort(input);

    int answer = 0;
    int lt = 1;
    int rt = input[N-1];
    while (lt <= rt) {
      int mid = (lt + rt) / 2; //정답 대상 값
      if (count(input, mid) >= C) {
        answer = mid;
        lt = mid + 1;
      } else {
        rt = mid - 1;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    int N = kbd.nextInt();
    int C = kbd.nextInt();
    int[] input = new int[N];
    for (int i = 0; i < N; i++) {
      input[i] = kbd.nextInt();
    }
    System.out.println(solution(N, C, input));
  }
}