import java.util.*;

class Edge implements Comparable<Edge> {
  public int v1, v2, cost;

  public Edge(int v1, int v2, int cost) {
    this.v1 = v1;
    this.v2 = v2;
    this.cost = cost;
  }

  @Override
  public int compareTo(Edge o) {
    return this.cost - o.cost;
  }
}

public class Main7A {

  static int[] unf;

  public static int find(int v) {
    if (v == unf[v])
      return v;
    return unf[v] = find(unf[v]);
  }

  public static int solution(int V, int E, List<Edge> input) {
    int output = 0;

    unf = new int[V + 1];
    for (int i = 1; i <= V; i++) {
      unf[i] = i;
    }

    Collections.sort(input); // cost 기준 오름차순 정렬

    // MST 구성
    // 회로가 생기지 않도록 Union-Find 알고리즘 사용해 같은 집합인지 확인
    for (Edge e : input) {
      int fa = find(e.v1);
      int fb = find(e.v2);
      if (fa != fb) { // 서로 다른 집합인지 확인
        output += e.cost;
        unf[fa] = fb; // 집합 합치기 (union 함수 역할)
      }
    }

    return output;
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    int V = kbd.nextInt();
    int E = kbd.nextInt();
    List<Edge> input = new ArrayList<>();
    for (int i = 0; i < E; i++) {
      input.add(new Edge(kbd.nextInt(), kbd.nextInt(), kbd.nextInt()));
    }
    System.out.println(solution(V, E, input));
  }
}