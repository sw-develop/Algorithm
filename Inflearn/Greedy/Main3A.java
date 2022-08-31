import java.util.*;

class Info implements Comparable<Info> {
  int time;
  char state;

  public Info(int time, char state) {
    this.time = time;
    this.state = state;
  }

  @Override
  public int compareTo(Info o) {
    if (this.time == o.time)
      return this.state - o.state;
    return this.time - o.time;
  }
}

public class Main3A {

  public static int solution(int N, List<Info> input) {
    Collections.sort(input);

    int output = 0, cnt = 0;
    for (Info i : input) {
      if (i.state == 's') {
        cnt++;
        output = Math.max(output, cnt);
      } else {
        cnt--;
      }
    }
    return output;
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    int N = kbd.nextInt();
    List<Info> input = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      input.add(new Info(kbd.nextInt(), 's'));
      input.add(new Info(kbd.nextInt(), 'e'));
    }
    System.out.println(solution(N, input));
  }
}