import java.util.*;

public class Main6A {

  public static List<Integer> solution(int N, int[] input) {
    List<Integer> output = new ArrayList<>();
    
    int[] tmp = input.clone();
    Arrays.sort(tmp);
    
    for (int i = 0; i < N; i++) {
      if (input[i] != tmp[i]) {
        output.add(i);
      }
    } 
    
    return output;
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    int N = kbd.nextInt();
    int[] input = new int[N];
    for (int i = 0; i < N; i++) {
      input[i] = kbd.nextInt();
    }
    for (int i : solution(N, input)) {
      System.out.print(i + " ");
    }
  }
}