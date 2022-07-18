import java.util.*;

public class Main1B {

  public static ArrayList<Integer> solution(int N, int[] arrN, int M, int[] arrM) {
    ArrayList<Integer> output = new ArrayList<>();
    int i = 0, j = 0;
    while (i < N && j < M) {
      if (arrN[i] < arrM[j]) output.add(arrN[i++]);
      else output.add(arrM[j++]);
    }
    while (i < N) output.add(arrN[i++]);
    while (j < M) output.add(arrM[j++]);
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