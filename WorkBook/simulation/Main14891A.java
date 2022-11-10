//16:18 - 17:12

import java.util.*;
import java.io.*;

public class Main14891A {

  static List<LinkedList<Character>> list = new LinkedList<>();

  public static void turn(int num, int dir) {
    if (dir == 1) { // 시계 방향 회전
      list.get(num - 1).addFirst(list.get(num - 1).removeLast());
    } else { // 반시계 방향 회전
      list.get(num - 1).addLast(list.get(num - 1).removeFirst());
    }
  }

  public static void num1(int dir) {
    // 1번 톱니바퀴 회전
    int tmpRight = list.get(0).get(2);
    turn(1, dir);

    // 다음 톱니바퀴 확인 (극이 다른 경우 회전)
    if (tmpRight == list.get(1).get(6))
      return;
    tmpRight = list.get(1).get(2);
    dir = dir * -1;
    turn(2, dir);

    if (tmpRight == list.get(2).get(6))
      return;
    tmpRight = list.get(2).get(2);
    dir = dir * -1;
    turn(3, dir);

    if (tmpRight == list.get(3).get(6))
      return;
    dir = dir * -1;
    turn(4, dir);
  }

  public static void num2(int dir) {
    // 2번 톱니바퀴 회전
    int tmpLeft = list.get(1).get(6);
    int tmpRight = list.get(1).get(2);
    turn(2, dir);

    if (tmpLeft != list.get(0).get(2))
      turn(1, dir * -1);

    if (tmpRight == list.get(2).get(6))
      return;
    tmpRight = list.get(2).get(2);
    dir = dir * -1;
    turn(3, dir);

    if (tmpRight == list.get(3).get(6))
      return;
    dir = dir * -1;
    turn(4, dir);
  }

  public static void num3(int dir) {
    // 3번 톱니바퀴 회전
    int tmpLeft = list.get(2).get(6);
    int tmpRight = list.get(2).get(2);
    turn(3, dir);

    if (tmpRight != list.get(3).get(6))
      turn(4, dir * -1);

    if (tmpLeft == list.get(1).get(2))
      return;
    tmpLeft = list.get(1).get(6);
    dir = dir * -1;
    turn(2, dir);

    if (tmpLeft == list.get(0).get(2))
      return;
    dir = dir * -1;
    turn(1, dir);
  }

  public static void num4(int dir) {
    // 4번 톱니바퀴 회전
    int tmpLeft = list.get(3).get(6);
    turn(4, dir);

    if (tmpLeft == list.get(2).get(2))
      return;
    tmpLeft = list.get(2).get(6);
    dir = dir * -1;
    turn(3, dir);

    if (tmpLeft == list.get(1).get(2))
      return;
    tmpLeft = list.get(1).get(6);
    dir = dir * -1;
    turn(2, dir);

    if (tmpLeft == list.get(0).get(2))
      return;
    dir = dir * -1;
    turn(1, dir);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    for (int i = 0; i < 4; i++) {
      list.add(new LinkedList<Character>());
    }

    for (int i = 0; i < 4; i++) {
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

      if (num == 1)
        num1(dir);
      else if (num == 2)
        num2(dir);
      else if (num == 3)
        num3(dir);
      else
        num4(dir);
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

톱니바퀴 상태 저장 자료구조 선택
1. 배열 - 시계/반시계 방향으로 회전 시 원소 위치 변경되므로 비효율적
2. 리스트 - 시계/반시계 방향으로 회전 시 맨 앞, 맨 뒤 원소만 추가/삭제 하면 되므로 효율적

톱니바퀴 회전에 대한 처리
- 입력받은 번호에 해당하는 톱니바퀴가 회전하는 경우에 대해 각 함수로 구성함 (코드 중복되므로 B에서 개선함)

*/