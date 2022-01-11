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
        if(this.distance < other.getDistance()){ // 오름차순 정렬
            return -1;
        }
        return 1;
    }
}

public class Main {

    public static final int INF = (int) 1e9; // 무한을 의미하는 값으로 10억을 설정
    // 노드의 개수(numOfNode), 간선의 개수(numOfEdge), 시작 노드 번호(start)
    public static int numOfNode, numOfEdge, start;
    // 그래프를 인접 리스트 형태로 구현
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    // 최단 거리 테이블
    public static int[] d = new int[100001]; // 노드의 개수는 최대 100,000개라고 가정

    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        // 시작노드로 가기 위한 최단 경로는 0으로 설정하여, 우선순위 큐에 삽입
        pq.offer(new Node(start, 0));
        d[start] = 0;
        while(!pq.isEmpty()){
            // 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
            Node node = pq.poll();
            int dist = node.getDistance();
            int now = node.getIndex();
            //현재 노드가 이미 처리된 적이 있는 노드라면 패스
            if(d[now] < dist) continue;
            // 현재 노드와 연결된 다른 인접한 노드들 확인
            for(int i = 0; i < graph.get(now).size(); i++){
                int cost = d[now] + graph.get(now).get(i).getDistance();
                // 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
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

        // 그래프 초기화
        for(int i = 0; i <= numOfNode; i++){
            graph.add(new ArrayList<>());
        }

        // 모든 간선 정보 입력 받기
        for(int i = 0; i < numOfEdge; i++){
            int a = kbd.nextInt();
            int b = kbd.nextInt();
            int c = kbd.nextInt();
            // a번 노드에서 b번 노드로 가는 비용 = c
            graph.get(a).add(new Node(b, c));
        }

        // 최단 거리 테이블을 모두 무한으로 초기화
        Arrays.fill(d, INF);

        // 다익스트라 알고리즘 수행
        dijkstra(start);

        // 모든 노드로 가기 위한 최단 거리 출력
        for(int i = 1; i <= numOfNode; i++){
            if(d[i] == INF) System.out.println("INFINITY"); // 도달할 수 없는 경우
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