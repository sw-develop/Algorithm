//8M 

import java.util.*;

public class Main2A {

  public static int solution(int[] input) {
    int output = 1;
    int maxVal = input[0];
    for(int i = 1; i < input.length; i++) {
      if (maxVal < input[i]) {
        maxVal = input[i];
        output++;
      } 
    }
    return output;
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    int N = kbd.nextInt();
    int[] input = new int[N];
    for(int i = 0; i < N; i ++) {
      input[i] = kbd.nextInt();
    }
    System.out.println(solution(input));
  }
}