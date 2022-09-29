// BOJ 2577

import java.io.*;

public class Main1A {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int A = Integer.parseInt(br.readLine());
    int B = Integer.parseInt(br.readLine());
    int C = Integer.parseInt(br.readLine());

    long input = A * B * C;
    int[] arr = new int[10];
    while (input > 0) {
      arr[input % 10]++;
      input /= 10;
    }

    for (int i : arr) {
      System.out.println(i);
    }
  }
}