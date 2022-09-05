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

  public static int solution(int N, List<Schedule> input) {
    int output = 0;

    Collections.sort(input);
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    int day = -1;
    for (Schedule s : input) {
      if (day == -1) {
        day = s.D;
      }
      if (day == s.D) {
        pq.offer(s.M);
      } else {
        output += pq.poll();
        day = s.D;
        pq.offer(s.D);
      }
    }
    output += pq.poll();

    return output;
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    int N = kbd.nextInt();
    List<Schedule> input = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      input.add(new Schedule(kbd.nextInt(), kbd.nextInt()));
    }
    System.out.println(solution(N, input));
  }
}