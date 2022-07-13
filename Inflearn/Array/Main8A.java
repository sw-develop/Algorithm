//27M

import java.util.*;

class Pair implements Comparable<Pair> {
  int score;
  int index;

  Pair(int score, int index) {
    this.score = score;
    this.index = index;
  }

  public int compareTo(Pair p) {
    if (this.score < p.score) return 1;
    else return -1;
  }
}

public class Main8A {

  public static int[] solution(int N, int[] input) {
    int[] output = new int[N];
    
    Pair[] pairArr = new Pair[N];
    for (int i = 0; i < N; i++) {
      pairArr[i] = new Pair(input[i], i);
    }
    Arrays.sort(pairArr); //내림차순 정렬 - 빠뜨리지 말기!

    int order = 0, frontScore = Integer.MAX_VALUE;
    for (int i = 0; i < N; i++) {
      Pair p = pairArr[i];
      if (p.score == frontScore) {
        output[p.index] = order;
      } else {
        order = i + 1;
        output[p.index] = order;
        frontScore = p.score;
      }
    }

    return output;
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    int N = kbd.nextInt();
    int[] input = new int[N];
    for (int i = 0; i < N; i++) {
      input[i] = kbd.nextInt();
    }
    for (int i : solution(N, input)) {
      System.out.print(i + " ");
    }
  }
}