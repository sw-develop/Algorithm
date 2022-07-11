//6m

import java.util.*;

public class Main1A {

  public static void solution(int[] input) {
    System.out.print(input[0] + " ");
    for(int i = 1; i < input.length; i++) {
      if (input[i] > input[i-1]) System.out.print(input[i] + " ");
    }
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    int N = kbd.nextInt();
    int[] arr = new int[N];
    for(int i = 0; i < N; i++) {
      arr[i] = kbd.nextInt();
    }
    solution(arr);
  }
}