import java.util.*;

class Schedule implements Comparable<Schedule> {
  int M;
  int D;

  public Schedule(int M, int D) {
    this.M = M;
    this.D = D;
  }

  @Override
  public int compareTo(Schedule o) { // D값 기준 내림차순
    return o.D - this.D;
  }
}

public class Main4A {

  static int N, max = Integer.MIN_VALUE;
  
  public static int solution(List<Schedule> input) {
    int output = 0;

    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    Collections.sort(input);

    int k = 0;
    for (int i = max; i >= 1; i--) {
      for (int j = k; j < N; j++) {
        if (input.get(j).D < i) {
          k = j;
          break;
        }
        pq.offer(input.get(j).M);
      }
      if (!pq.isEmpty()) output += pq.poll();
    }

    return output;
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    N = kbd.nextInt();
    List<Schedule> input = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      int M = kbd.nextInt();
      int D = kbd.nextInt();
      input.add(new Schedule(M,D));
      max = Math.max(max, D);
    }
    System.out.println(solution(input));
  }
}