import java.util.*;
import java.io.*;

public class Main14891C {

  static char[][] gear = new char[4][8];

  public static void rotate(int num, int dir) {
    if (dir == 1) { // 시계 방향 회전
      char tmp = gear[num][7];
      for (int i = 7; i >= 1; i--)
        gear[num][i] = gear[num][i-1];
      gear[num][0] = tmp;
    } else { // 반시계 방향 회전
      char tmp = gear[num][0];
      for (int i = 0; i <= 6; i++)
        gear[num][i] = gear[num][i+1];
      gear[num][7] = tmp;
    }
  }

  public static void go(int num, int dir) {
    int[] dirs = new int[4]; //각 톱니바퀴의 회전 방향 저장
    dirs[num] = dir;

    //왼쪽으로 회전 전파
    int idx = num;
    while (idx > 0 && gear[idx][6] != gear[idx-1][2]) {
      dirs[idx-1] = dirs[idx] * -1;
      idx -= 1;
    }
    
    //오른쪽으로 회전 전파
    idx = num;
    while (idx < 3 && gear[idx][2] != gear[idx+1][6]) {
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

    for (int i = 0; i < 4; i++) { // 톱니바퀴 상태 저장
      String str = br.readLine();
      for (int j = 0; j < str.length(); j++) {
        gear[i][j] = str.charAt(j);
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
      if (gear[i][0] == '1')
        answer += Math.pow(2, i);
    }

    System.out.println(answer);
  }
}

/* 문제회고

수정 사항
- 톱니바퀴 상태 저장 시 배열 사용함

*/