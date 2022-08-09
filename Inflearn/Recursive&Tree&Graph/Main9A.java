//Q. 주어진 이진트리에서 루트 노드 부터 말단 노드까지의 길이 중 가장 최소 길이를 구하시오.

import java.util.*;

class Node {
  int val;
  Node lt;
  Node rt;

  public Node(int val) {
    this.val = val;
    this.lt = null;
    this.rt = null;
  }
}

public class Main9A {

  public static int solution(Node root) {
    Queue<Node> q = new LinkedList<>();
    q.offer(root);
    int L = 0;
    while (!q.isEmpty()) {
      int len = q.size(); // 레벨별 원소의 개수
      for (int i = 0; i < len; i++) {
        Node node = q.poll();
        if (node.lt == null && node.rt == null)
          return L;
        if (node.lt != null)
          q.offer(node.lt);
        if (node.rt != null)
          q.offer(node.rt);
      }
      L++;
    }
    return L;
  }

  public static void main(String[] args) {
    Node root = new Node(1);
    root.lt = new Node(2);
    root.rt = new Node(3);
    root.lt.lt = new Node(4);
    root.lt.rt = new Node(5);
    System.out.println(solution(root));
  }
}