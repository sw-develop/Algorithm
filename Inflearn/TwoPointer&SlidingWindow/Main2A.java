import java.util.*;

public class Main2A {

  public static ArrayList<Long> solution(int N, int M, Long[] arrA, Long[] arrB) {
    ArrayList<Long> output = new ArrayList<>();

    //오름차순 정렬
    Arrays.sort(arrA);
    Arrays.sort(arrB);
    
    int i = 0, j = 0;
    while (i < N && j < M) {
      if (arrA[i] < arrB[j]) i++;
      else if (arrA[i] > arrB[j]) j++;
      else {
        output.add(arrA[i]);
        i++; j++;
      }
    }
    
    return output;
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    int N = kbd.nextInt();
    Long[] arrA = new Long[N];
    for (int i = 0; i < N; i++) {
      arrA[i] = kbd.nextLong();
    }
    int M = kbd.nextInt();
    Long[] arrB = new Long[M];
    for (int i = 0; i < M; i++) {
      arrB[i] = kbd.nextLong();
    }
    for (Long l : solution(N, M, arrA, arrB)) {
      System.out.print(l + " ");
    }
  }
}