import java.util.*;

class Meeting implements Comparable<Meeting> {
  int startTime;
  int endTime;

  public Meeting(int startTime, int endTime) {
    this.startTime = startTime;
    this.endTime = endTime;
  }

  @Override
  public int compareTo(Meeting o) {
    if (this.endTime == o.endTime)
      return this.startTime - o.startTime;
    return this.endTime - o.endTime;
  }
}

public class Main2A {

  public static int solution(int n, List<Meeting> input) {
    int output = 0;

    Collections.sort(input);

    int endTime = 0;
    for (Meeting m : input) {
      if (m.startTime >= endTime) {
        output++;
        endTime = m.endTime;
      }
    }

    return output;
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    int n = kbd.nextInt();
    List<Meeting> input = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      input.add(new Meeting(kbd.nextInt(), kbd.nextInt()));
    }
    System.out.println(solution(n, input));
  }
}