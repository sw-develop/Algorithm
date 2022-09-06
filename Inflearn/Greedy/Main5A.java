import java.util.*;

class Node implements Comparable<Node> {
  int index;
  int distance;

  public Node(int index, int distance){
    this.index = index;
    this.distance = distance;
  }

  @Override
  public int compareTo(Node other){
    return this.distance - other.distance;
  }
}

public class Main5A {

    public static final int INF = (int) 1e9;

    public static int numOfNode, numOfEdge, start;

    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    public static int[] d = new int[100001];

    public static void dijkstra(int start){
      PriorityQueue<Node> pq = new PriorityQueue<>();
      
      pq.offer(new Node(start, 0));
      d[start] = 0;
      while (!pq.isEmpty()) {
        Node node = pq.poll();
        int dist = node.distance;
        int now = node.index;
        
        if (d[now] < dist) continue;

        for (int i = 0; i < graph.get(now).size(); i++) {
          int cost = d[now] + graph.get(now).get(i).distance;
          if (cost < d[graph.get(now).get(i).index]) {
            d[graph.get(now).get(i).index] = cost;
            pq.offer(new Node(graph.get(now).get(i).index, cost));
          }
        }
      }
    }

    public static void main(String[] args){
        Scanner kbd = new Scanner(System.in);

        numOfNode = kbd.nextInt();
        numOfEdge = kbd.nextInt();
        start = kbd.nextInt();

        for(int i = 0; i <= numOfNode; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < numOfEdge; i++){
            int a = kbd.nextInt();
            int b = kbd.nextInt();
            int c = kbd.nextInt();
            graph.get(a).add(new Node(b, c));
        }

        Arrays.fill(d, INF);

        dijkstra(start);

        for(int i = 1; i <= numOfNode; i++){
            if(d[i] == INF) System.out.println("INFINITY");
            else System.out.println(d[i]);
        }
    }

}