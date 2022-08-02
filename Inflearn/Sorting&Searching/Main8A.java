import java.util.*;

public class Main8A {

  public static int solution(int N, int M, int[] input) {
    Arrays.sort(input);

    int left = 0, right = N - 1;
    int output = 0;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (M == input[mid]) {
        output = mid + 1;
        break;
      } else if (M < input[mid])
        right = mid - 1;
      else
        left = mid + 1;
    }
    return output;
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