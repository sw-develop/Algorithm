import java.util.*;

public class Main8A {

  public static int solution(int S, int E) {
    int num = E-S;  
    int cnt = 0;
    while (num != 0) {
      if (num - 5 > 0) {
        num -= 5;
        cnt++;
      }
      else if (num - 5 == 0) {
        num -= 5;
        cnt++;
      }
      else {
        if (num - 5 <= -5) {
          num += 1;
          cnt++;
        }
        else if (num - 5 <= -3) { //+5 가는 것보다 +1 가는 것이 더 최소인 경우
          num -= 1;
          cnt++;
        }
        else {
          num -= 5;
          cnt++;
        }
      }
    }
    return cnt;
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    int S = kbd.nextInt();
    int E = kbd.nextInt();

    System.out.println(solution(S, E));
  }
}