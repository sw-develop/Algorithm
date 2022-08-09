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

public class Main9B {

  public static int dfs(int L, Node root) {
    if (root.lt == null && root.rt == null)
      return L;
    else
      return Math.min(dfs(L + 1, root.lt), dfs(L + 1, root.rt));
  }

  public static void main(String[] args) {
    Node root = new Node(1);
    root.lt = new Node(2);
    root.rt = new Node(3);
    root.lt.lt = new Node(4);
    root.lt.rt = new Node(5);
    System.out.println(dfs(0, root));
  }
}