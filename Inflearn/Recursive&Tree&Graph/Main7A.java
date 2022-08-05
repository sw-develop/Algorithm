//이진트리 순회 (BFS)

import java.util.*;

class Node {
  int data;
  Node lt, rt;

  public Node(int val) {
    this.data = val;
    lt = rt = null;
  }
}

public class Main7A {

  public static void bfs(Node root) {
    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int len = queue.size();
      for (int i = 0; i < len; i++) {
        Node node = queue.poll();
        System.out.print(node.data + " ");
        if (node.lt != null) queue.offer(node.lt);
        if (node.rt != null) queue.offer(node.rt);
      }
      System.out.println();
    }
  }
  
  public static void main(String[] args) {
    Node root = new Node(1);
    root.lt = new Node(2);
    root.rt = new Node(3);
    root.lt.lt = new Node(4);
    root.lt.rt = new Node(5);
    root.rt.lt = new Node(6);
    root.rt.rt = new Node(7);
    bfs(root);
  }
}
