import java.io.*;

public class Main14499B {

  static int N, M, x, y, K;
  static int[][] map;

  static StringBuilder sb = new StringBuilder();

  static int[] dx = {0, 0, 0, -1, 1}; //동서북남
  static int[] dy = {0, 1, -1, 0, 0};

  static int[] dice = new int[7]; //주사위

  static int[][] idx = {
    {},        // dummy
    {2,6,4,5}, // 동쪽, 5->2, 2->6, 6->4, 4->5
    {2,5,4,6}, // 서쪽, 6->2, 2->5, 5->4, 4->6
    {3,2,1,4}, // 북쪽, 4->3, 3->2, 2->1, 1->4
    {2,3,4,1}, // 남쪽, 1->2, 2->3, 3->4, 4->1
  };

  public static void roll(int dir) {
    //회전 시 기존 주사위의 값을 별도로 보존하기 위한 배열 생성
    int[] tmp = new int[7];
    for (int i = 1; i <= 6; i++) tmp[i] = dice[i];
    //주사위 굴리기
    for (int i = 0; i < 4; i++)
      tmp[idx[dir][i]] = dice[idx[dir][(i+3) % 4]];
    //회전 결과값을 기존 주사위에 대입
    for (int i = 1; i <= 6; i++) dice[i] = tmp[i];
  }

  public static void move(int dir) {
    //1. 주사위 위치 이동
    int nx = x + dx[dir];
    int ny = y + dy[dir];
    if (nx < 0 || nx >= N || ny < 0 || ny >= M) return;
    x = nx; y = ny;
    //2. 주사위, 지도 값 업데이트
    //주사위 굴려서 주사위 값 위치 변경
    roll(dir);
    //지도 칸에 쓰여있는 수에 따라 지도 칸의 값과 주사위의 바닥면 값 업데이트
    if (map[x][y] == 0) { 
      map[x][y] = dice[4];
    } else {
      dice[4] = map[x][y];
      map[x][y] = 0;
    }
    //상단에 쓰여있는 값 저장
    sb.append(dice[2]).append('\n');
  }
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] tmp = br.readLine().split(" ");
    N = Integer.parseInt(tmp[0]); 
    M = Integer.parseInt(tmp[1]); 
    x = Integer.parseInt(tmp[2]); 
    y = Integer.parseInt(tmp[3]); 
    K = Integer.parseInt(tmp[4]);

    map = new int[N][M];
    for (int i = 0; i < N; i++) {
      tmp = br.readLine().split(" ");
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(tmp[j]);
      }
    }

    tmp = br.readLine().split(" ");
    for (String s : tmp) {
      move(Integer.parseInt(s));
    }
    System.out.println(sb);
  } 
}

/* 문제 회고

<수정>
주사위 값 저장 방식 - 기존: 2차원 배열, 수정: 1차원 배열

*/