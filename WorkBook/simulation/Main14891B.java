import java.util.*;
import java.io.*;

public class Main14891B {

  static List<LinkedList<Character>> list = new LinkedList<>();

  public static void rotate(int num, int dir) {
    if (dir == 1) { // 시계 방향 회전
      list.get(num).addFirst(list.get(num).removeLast());
    } else { // 반시계 방향 회전
      list.get(num).addLast(list.get(num).removeFirst());
    }
  }

  public static void go(int num, int dir) {
    int[] dirs = new int[4]; //각 톱니바퀴의 회전 방향 저장
    dirs[num] = dir;

    //왼쪽으로 회전 전파
    int idx = num;
    while (idx > 0 && list.get(idx).get(6) != list.get(idx-1).get(2)) {
      dirs[idx-1] = dirs[idx] * -1;
      idx -= 1;
    }
    
    //오른쪽으로 회전 전파
    idx = num;
    while (idx < 3 && list.get(idx).get(2) != list.get(idx+1).get(6)) {
      dirs[idx+1] = dirs[idx] * -1;
      idx += 1;
    }

    //회전 수행
    for (int i = 0; i < 4; i++) {
      if (dirs[i] == 0) continue;
      rotate(i, dirs[i]);
    } 
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    for (int i = 0; i < 4; i++) {
      list.add(new LinkedList<Character>());
    }

    for (int i = 0; i < 4; i++) { // 톱니바퀴 상태 저장
      String str = br.readLine();
      for (int j = 0; j < str.length(); j++) {
        list.get(i).add(str.charAt(j));
      }
    }

    int K = Integer.parseInt(br.readLine());
    while (K-- > 0) {
      String[] tmp = br.readLine().split(" ");
      int num = Integer.parseInt(tmp[0]);
      int dir = Integer.parseInt(tmp[1]);
      go(num - 1, dir);
    }

    // 톱니바퀴 점수 계산
    int answer = 0;
    for (int i = 0; i < 4; i++) {
      if (list.get(i).get(0) == '1')
        answer += Math.pow(2, i);
    }

    System.out.println(answer);
  }
}

/* 문제회고

수정 사항
- 1회 회전 시 왼쪽과 오른쪽으로의 회전 전파 확인
- 각 톱니바퀴의 회전 방향만 저장해두면 됨

*/