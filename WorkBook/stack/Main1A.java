import java.util.*;
import java.io.*;

public class Main1A {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int K = Integer.parseInt(br.readLine());
    Stack<Integer> st = new Stack<>();
    for (int i = 0; i < K; i++) {
      int n = Integer.parseInt(br.readLine());
      if (n != 0) st.push(n);
      else st.pop();
    }

    int sum = 0;
    for (int i : st) {
      sum += i;
    }
    System.out.println(sum);
  }
}