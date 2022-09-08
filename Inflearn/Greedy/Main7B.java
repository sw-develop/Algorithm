import java.util.*;

class Edge implements Comparable<Edge> {
  public int v, w;

  public Edge(int v, int w) {
    this.v = v;
    this.w = w;
  }

  @Override
  public int compareTo(Edge o) {
    return this.w - o.w;
  }
}

public class Main7B {

  static int[] ch;

  public static int solution(int V, int E, List<List<Edge>> input, int startVertex) {
    int answer = 0;
    
    PriorityQueue<Edge> pq = new PriorityQueue<>();

    pq.offer(new Edge(startVertex, 0));
    while (!pq.isEmpty()) {
      Edge e1 = pq.poll();
      if (ch[e1.v] == 0) { //사이클 형성하지 않도록 하기 위함
        answer += e1.w;
        ch[e1.v] = 1;
        for (Edge e2 : input.get(e1.v)) {
          if (ch[e2.v] == 0) pq.offer(e2);
        } 
      }
    }
    
    return answer;
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    int V = kbd.nextInt();
    int E = kbd.nextInt();

    ch = new int[V + 1];

    //인접리스트 구성
    List<List<Edge>> input = new ArrayList<>();
    for (int i = 0; i < V + 1; i++) {
      input.add(new ArrayList<Edge>());
    }
    for (int i = 0; i < E; i++) { //간선 추가
      int v1 = kbd.nextInt();
      int v2 = kbd.nextInt();
      int w = kbd.nextInt();
      input.get(v1).add(new Edge(v2, w)); //무방향 주의
      input.get(v2).add(new Edge(v1, w));
    }

    System.out.println(solution(V, E, input, 1));
  }
}