import java.util.*;

class Patient {
  int id;
  int priority;

  public Patient(int id, int priority) {
    this.id = id;
    this.priority = priority;
  }
}

public class Main8A {

  public static int solution(int N, int M, int[] input) {
    int output = 0;
    Queue<Patient> q = new LinkedList<>();
    for (int i = 0; i < N; i++) {
      q.offer(new Patient(i, input[i]));
    }
    while (true) {
      Patient tmp = q.poll();
      Iterator<Patient> it = q.iterator();
      while (it.hasNext()) {
        Patient next = it.next();
        if (next.priority > tmp.priority) {
          q.offer(tmp);
          tmp = null;
          break;
        }
      }
      if (tmp != null) {
        output++;
        if (tmp.id == M)
          return output;
      }
    }
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    int N = kbd.nextInt();
    int M = kbd.nextInt();
    int[] input = new int[N];
    for (int i = 0; i < N; i++) {
      input[i] = kbd.nextInt();
    }
    System.out.println(solution(N, M, input));
  }
}