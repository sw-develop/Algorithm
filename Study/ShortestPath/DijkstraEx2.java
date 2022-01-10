import java.util.*;

class Node implements Comparable<Node>{
  private int index;  // 노드 번호
  private int distance; // 가중치 

  public Node(int index, int distance){
    this.index = index;
    this.distance = distance;
  }

  public int getIndex(){
    return index;
  }

  public int getDistance(){
    return distance;
  }

  // 가중치(거리)가 작은 것이 높은 우선순위를 가지도록 설정 
  @Override
  public int compareTo(Node other){
    if(this.distance < other.getDistance()){
      return -1;
    }
    return 1;
  }
}

public class DijkstraEx2 {
  public static final int INF = (int) 1e9;  // 무한을 의미하는 값으로 10억을 설정

  // 노드의 개수, 간선의 개수, 시작 노드 번호
  // 노드의 개수는 최대 100,000개라고 가정 
  public static int numOfNode, numOfEdge, start;

  // 각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
  public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();

  // 최단 거리 테이블 - 무한대로 초기화 됨 
  public static int[] d = new int[100001];

  public static void dijkstra(int start){
    PriorityQueue<Node> pqueue = new PriorityQueue<Node>();

    // 시작 노드로 가기 위한 최단 경로는 0으로 설정하고, 큐에 삽입
    pqueue.offer(new Node(start, 0));
    d[start] = 0;
    while(!pqueue.isEmpty()){ // 큐가 비어있지 않다면 
      Node node = pqueue.poll(); 
      int dist = node.getDistance();  // 현재 노드까지의 가중치
      int now = node.getIndex();  // 현재 노드 번호 

      // 현재 노드가 이미 처리된 노드라면 무시 
      if(d[now] < dist) continue;

      // 현재 노드와 연결된 다른 인접한 노드들을 확인
      for(int i = 0; i < graph.get(now).size(); i++){
        Node adjacentNode = graph.get(now).get(i);
        int cost = d[now] + adjacentNode.getDistance();
        // 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우 -> 해당 노드에 대한 거리 테이블 값 업데이트
        if(cost < d[adjacentNode.getIndex()]){
          d[adjacentNode.getIndex()] = cost;
          pqueue.offer(new Node(adjacentNode.getIndex(), cost));
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
      graph.add(new ArrayList<Node>());
    }

    // 모든 간선 정보 입력받기
    for(int i = 0; i < numOfEdge; i++){
      int a = kbd.nextInt();
      int b = kbd.nextInt();
      int c = kbd.nextInt();

      // a번 노드에서 b번 노드로 가는 비용이 c라는 의미
      graph.get(a).add(new Node(b, c));
    }

    // 최단 거리 테이블 무한으로 초기화
    Arrays.fill(d, INF);

    // 다익스트라 알고리즘 수행
    dijkstra(start);

    // 모든 노드로 가기 위한 최단 거리 출력 
    for(int i = 1; i <= numOfNode; i++){
      // 도달할 수 없는 경우, 무한(INF)라고 출력
      if(d[i] == INF){
        System.out.println("INF");
      }

      // 도달할 수 있는 경우 거리 출력 
      else{
        System.out.println(d[i]);
      }
    }
  }
}