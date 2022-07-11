import java.util.*;

public class Main3A {

  public static final int SCISSOR = 1;
  public static final int ROCK = 2;
  public static final int PAPER = 3;

  public static char play(int a, int b) {
    if (a == b) return 'D'; //비기는 경우
    if (a == SCISSOR && b == PAPER) return 'A'; //A가 이기는 경우 
    if (a == ROCK && b == SCISSOR) return 'A';
    if (a == PAPER && b == ROCK) return 'A';
    return 'B'; //B가 이기는 경우
  }
  
  public static String solution(int[] A, int[] B) {
    String output = "";
    for (int i = 0; i < A.length; i++) {
      output += (play(A[i], B[i]));
    }
    return output;
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    int N = kbd.nextInt();
    int[] A = new int[N];
    int[] B = new int[N];
    for(int i = 0; i < N; i++) {
      A[i] = kbd.nextInt();
    }
    for(int i = 0; i < N; i++) {
      B[i] = kbd.nextInt();
    }
    for(char c : solution(A, B).toCharArray()) {
      System.out.println(c);
    }
  }
}