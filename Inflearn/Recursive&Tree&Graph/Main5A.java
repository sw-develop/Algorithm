//이진트리순회 - root 노드 기준으로 달라짐

import java.util.*;

class Node {
  int data;
  Node lt, rt;

  public Node(int val) {
    this.data = val;
    lt = rt = null;
  }
  
}

public class Main5A {

  private static Node root;

  public static void preOrder(Node root) { //전위순회
    if (root == null) return;
    else {
      System.out.print(root.data + " ");
      preOrder(root.lt);
      preOrder(root.rt);
    }
  }

  public static void inOrder(Node root) { //중위순회
    if (root == null) return;
    else {
      inOrder(root.lt);
      System.out.print(root.data + " ");
      inOrder(root.rt);
    }
  }

  public static void postOrder(Node root) { //후위순회
    if (root == null) return;
    else {
      postOrder(root.lt);
      postOrder(root.rt);
      System.out.print(root.data + " ");
    }
  }

  public static void main(String[] args) {
    root = new Node(1);
    root.lt = new Node(2);
    root.rt = new Node(3);
    root.lt.lt = new Node(4);
    root.lt.rt = new Node(5);
    root.rt.lt = new Node(6);
    root.rt.rt = new Node(7);
    
    preOrder(root);
    System.out.println();
    inOrder(root);
    System.out.println();
    postOrder(root);
  }

}