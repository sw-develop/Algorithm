import java.util.*;

public class Main3A {

  public static int solution(int N, int M, int[][] board, int[] moves) {
    int output = 0;
    Stack<Integer> stack = new Stack<>();
    for (int pos : moves) {
      for (int i = 0; i < board.length; i++) {
        if (board[i][pos - 1] != 0) {
          int tmp = board[i][pos - 1];
          board[i][pos - 1] = 0;
          if (!stack.empty() && stack.peek() == tmp) {
            stack.pop();
            output += 2;
          } else {
            stack.push(tmp);
          }
          break;
        }
      }
    }
    return output;
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    int N = kbd.nextInt();
    int[][] board = new int[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        board[i][j] = kbd.nextInt();
      }
    }
    int M = kbd.nextInt();
    int[] moves = new int[M];
    for (int i = 0; i < M; i++) {
      moves[i] = kbd.nextInt();
    }
    System.out.println(solution(N, M, board, moves));
  }
}