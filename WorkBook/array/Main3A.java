// BOJ 3273

import java.util.*;
import java.io.*;

public class Main3A {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] input = new int[n];
    String[] str = br.readLine().split(" ");
    for (int i = 0; i < n; i++)
      input[i] = Integer.parseInt(str[i]);
    int x = Integer.parseInt(br.readLine());

    Arrays.sort(input); // 오름차순 정렬
    int left = 0, right = n - 1;
    int answer = 0;
    while (left < right) {
      int sum = input[left] + input[right];
      if (sum == x) {
        answer++;
        left++;
        right--;
      } else if (sum > x)
        right--;
      else
        left++;
    }

    System.out.println(answer);
  }
}