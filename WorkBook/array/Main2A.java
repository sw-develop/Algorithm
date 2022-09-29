// BOJ 1475

import java.io.*;

public class Main2A {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int input = Integer.parseInt(br.readLine());
    int[] arr = new int[10];
    while (input > 0) {
      arr[input % 10]++;
      input /= 10;
    }

    int ans = 0;
    for (int i = 0; i < 10; i++) {
      if (i == 6 || i == 9)
        continue;
      ans = Math.max(ans, arr[i]);
    }

    //6, 9 처리
    ans = Math.max(ans, (arr[6] + arr[9] + 1) / 2);
    System.out.println(ans);
  }
}