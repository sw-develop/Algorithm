import java.util.*;

public class Main1A {

  static int total = 0;
  static String answer = "NO";
  static boolean flag = false;
  
  public static void dfs(int idx, int sum, int[] arr) {
    if (flag) return;
    if (sum > total / 2) return;
    if (idx == arr.length) {
      if (sum == (total - sum)) {
        answer = "YES";
        flag = true;
      }
    }
    else {
      dfs(idx + 1, sum + arr[idx], arr);
      dfs(idx + 1, sum, arr);
    }
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    int N = kbd.nextInt();
    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = kbd.nextInt();
      total += arr[i];
    }
    dfs(0, 0, arr);
    System.out.println(answer);
  }
}