//18M

import java.util.*;

public class Main1A {

  public static int[] solution(int N, int[] arrN, int M, int[] arrM) {
    int[] output = new int[N + M];

    int i = 0, j = 0, idx = 0;
    while (i < N && j < M) {
      if (arrN[i] < arrM[j]) {
        output[idx] = arrN[i];
        i++; idx++;
      }
      else {
        output[idx] = arrM[j];
        j++; idx++;
      }
    }

    if (i != N) {
      for (int k = i; k < N; k++) {
        output[idx] = arrN[k];
        idx++;
      }
    }

    if (j != M) {
      for (int k = j; k < M; k++) {
        output[idx] = arrM[k];
        idx++;
      }
    }
    
    return output;
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    int N = kbd.nextInt();
    int[] arrN = new int[N];
    for (int i = 0; i < N; i++) {
      arrN[i] = kbd.nextInt();
    }
    int M = kbd.nextInt();
    int[] arrM = new int[M];
    for (int i = 0; i < M; i++) {
      arrM[i] = kbd.nextInt();
    }
    for (int i : solution(N, arrN, M, arrM)) {
      System.out.print(i + " ");
    }
  }
}