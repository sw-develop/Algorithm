import java.util.*;
import java.io.*;

public class Main13335A {

  static int n, w, L, ans;
  static int bridge[] = new int[101]; // 다리의 칸별 무게(트럭의 무게)를 저장하는 변수
  static Queue<Integer> truck = new LinkedList<>(); // 이동하는 트럭의 목록을 순차적으로 저장하는 변수

  // 다리가 비었는지 확인하는 함수
  static boolean isEmpty() {
    for (int i = 0; i < w; i++)
      if (bridge[i] != 0) return false;
    return true;
  }

  // 트럭의 이동을 진행하는 함수
  static void go() {
    for (int i = w-1; i > 0; i--)
      bridge[i] = bridge[i-1];
    bridge[0] = 0;
  }

  // 다리 위 트럭의 무게를 계산하는 함수
  static int calculate() {
    int sum = 0;
    for (int i = 0; i < w; i++)
      sum += bridge[i];
    return sum;
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
      int tmp = calculate(); // 현재 다리 위 트럭들의 무게
      if (tmp <= L) {
        tmp -= bridge[w-1]; // 나갈 트럭의 무게 제외
        go();
        // 추가로 이동할 트럭이 있고, 다리가 무게를 버틸 경우
        if (!truck.isEmpty() && (tmp + truck.peek()) <= L) {
          bridge[0] = truck.poll();
        }
      }
      ans++;
    } while (!isEmpty()); // 모든 트럭이 이동하여 다리가 빌 때까지 반복

    System.out.println(ans);
  }
}

/* 문제 회고

<풀이>
다리 - 배열로 표현
트럭 무게 - Queue로 표현 (순서 유지 필요함)

*/