import java.util.*;

class Pair implements Comparable<Pair> {
  int x;
  int y;

  public Pair(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public int compareTo(Pair other) {
    // this - 앞 객체, other - 다음 객체
    if (this.x == other.x)
      return this.y - other.y;
    else
      return this.x - other.x;
  }
}

public class Main7A {

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    int N = kbd.nextInt();
    List<Pair> input = new LinkedList<>();
    for (int i = 0; i < N; i++) {
      int x = kbd.nextInt();
      int y = kbd.nextInt();
      input.add(new Pair(x, y));
    }
    Collections.sort(input);
    for (Pair p : input) {
      System.out.printf("%d %d\n", p.x, p.y);
    }
  }
}