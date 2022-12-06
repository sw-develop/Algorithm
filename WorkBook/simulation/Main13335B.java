import java.util.*;
import java.io.*;

public class Main13335B {

  static int n, w, L, ans = 0;
  static int[] bridge = new int[101];
  static Queue<Integer> truck = new LinkedList<>();

  // 다리 위의 트럭의 무게 계산하는 함수
  static int calculate() {
    int sum = 0;
    for (int i = 0; i < w; i++)
      sum += bridge[i];
    return sum;
  }

  // 다리 위의 트럭을 한 칸씩 이동
  static void go() {
    for (int i = w-1; i > 0; i--)
      bridge[i] = bridge[i-1];
    bridge[0] = 0; // 다리의 시작 위치는 0으로 초기화
  }

  // 다리가 비었는지 확인하는 함수
  static boolean isEmpty() {
    for (int i = 0; i < w; i++)
      if (bridge[i] != 0) return false;
    return true;
  }
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] str = br.readLine().split(" ");
    n = Integer.parseInt(str[0]); w = Integer.parseInt(str[1]); L = Integer.parseInt(str[2]);
    str = br.readLine().split(" ");
    for (String s : str) {
      truck.offer(Integer.parseInt(s));
    }

    do { // 한 번의 수행에 대한 정의
      int tmp = calculate(); // 다리 위의 트럭의 무게 계산
      if (tmp <= L) {
        tmp -= bridge[w-1]; // 다리를 건넌 트럭 무게 제외
        go(); // 다리 위의 트럭 한 칸씩 이동
        if (!truck.isEmpty() && (tmp + truck.peek()) <= L) { // 이동할 트럭이 존재하고, 다리가 버틸 수 있는 무게일 때
          bridge[0] = truck.poll();
        }
      }
      ans++;
    } while (!isEmpty()); // 트럭이 모두 지나가 빈 다리가 아닐 때까지 반복
    System.out.println(ans);
  }
}