import java.util.*;

class Node implements Comparable<Node> {

    private int index;
    private int distance;

    public Node(int index, int distance){
        this.index = index;
        this.distance = distance;
    }

    public int getIndex(){
        return this.index;
    }

    public int getDistance(){
        return this.distance;
    }

    @Override
    public int compareTo(Node other){
        if(this.distance < other.getDistance()){
            return -1;
        }
        return 1;
    }
}

public class Main {

    public static final int INF = (int) 1e9;

    public static int numOfNode, numOfEdge, start;

    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    public static int[] d = new int[100001];

    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start, 0));
        d[start] = 0;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            int dist = node.getDistance();
            int now = node.getIndex();

            if(d[now] < dist) continue;

            for(int i = 0; i < graph.get(now).size(); i++){
                int cost = d[now] + graph.get(now).get(i).getDistance();
                if(cost < d[graph.get(now).get(i).getIndex()]){
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
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


/*
[Input Example]
6 11
1
1 2 2
1 3 5
1 4 1
2 3 3
2 4 2
3 2 3
3 6 5
4 3 3
4 5 1
5 3 1
5 6 2

[Output Example]
0
2
3
1
2
4
*/