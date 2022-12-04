import java.io.*;

public class Main14499A {

  static int N, M, x, y, K;
  static int[][] map;

  static StringBuilder sb = new StringBuilder();

  static int[] dx = {0, 0, 0, -1, 1}; //동서북남
  static int[] dy = {0, 1, -1, 0, 0};

  static int[][] dice = new int[4][3]; //주사위

  public static void roll(int dir) {
    if (dir == 1) { //동
      int tmpL = dice[1][0]; int tmpR = dice[1][2];
      dice[1][0] = dice[3][1];
      dice[1][2] = dice[1][1];
      dice[3][1] = tmpR;
      dice[1][1] = tmpL;
    } else if (dir == 2) { //서
      int tmpL = dice[1][0]; int tmpR = dice[1][2];
      dice[1][0] = dice[1][1];
      dice[1][2] = dice[3][1];
      dice[1][1] = tmpR;
      dice[3][1] = tmpL;
    } else if (dir == 3) { //북
      int tmp = dice[0][1];
      for (int i = 0; i <= 2; i++) {
        dice[i][1] = dice[i+1][1];
      }
      dice[3][1] = tmp;
    } else { //남
      int tmp = dice[3][1];
      for (int i = 3; i >= 1; i--) {
        dice[i][1] = dice[i-1][1];
      }
      dice[0][1] = tmp;
    }
  }

  public static void move(int dir) {
    //1. 주사위 이동
    int nx = x + dx[dir];
    int ny = y + dy[dir];
    if (nx < 0 || nx >= N || ny < 0 || ny >= M) return;
    x = nx; y = ny;
    //2. 주사위, 지도 값 업데이트
    //주사위 굴려서 주사위 값 위치 변경
    roll(dir);
    //지도 칸에 쓰여있는 수에 따라 지도 칸의 값과 주사위의 바닥면 값 업데이트
    if (map[x][y] == 0) { 
      map[x][y] = dice[3][1];
    } else {
      dice[3][1] = map[x][y];
      map[x][y] = 0;
    }
    //상단에 쓰여있는 값 저장
    sb.append(dice[1][1]).append('\n');
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