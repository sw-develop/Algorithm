import java.util.*;
import java.io.*;

public class Main3A {

  static int[] dx = { -1, 1, 0, 0, 0, 0 }; // 상하좌우 앞뒤
  static int[] dy = { 0, 0, -1, 1, 0, 0 };
  static int[] dh = { 0, 0, 0, 0, 1, -1 };

  public static int solution(int N, int M, int H, int[][][] box, int tomatoA, int tomatoB) {
    int ans = 0;

    Queue<int[]> q = new LinkedList<>(); // 익은 토마토 좌표 저장
    // 큐 초기값 설정
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        for (int h = 0; h < H; h++) {
          if (box[i][j][h] == 1) {
            q.offer(new int[] { i, j, h });
          }
        }
      }
    }

    // while문으로 빈큐가 아닐 동안 반복
    while (!q.isEmpty() && tomatoB >= 1) {
      int L = q.size();
      for (int i = 0; i < L; i++) {
        int[] tmp = q.poll();
        int x = tmp[0];
        int y = tmp[1];
        int h = tmp[2];
        
        // 상하좌우 앞뒤 익지 않은 토마토 좌표 저장
        for (int idx = 0; idx < dx.length; idx++) {
          int nx = x + dx[idx];
          int ny = y + dy[idx];
          int nh = h + dh[idx];
          if (nx >= 0 && nx < N && ny >= 0 && ny < M && nh >= 0 && nh < H && box[nx][ny][nh] == 0) {
            q.offer(new int[]{nx, ny, nh});
            box[nx][ny][nh] = 1;
            tomatoB--;
          }
        }
      }
      ans++;
    }

    // 익지 않은 토마토 개수가 1 이상일 때 -1 출력 예외 처리
    if (tomatoB >= 1)
      return -1;
    return ans;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int M = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());
    int H = Integer.parseInt(st.nextToken());

    int[][][] box = new int[N][M][H];
    int tomatoA = 0; // 익은 토마토 개수
    int tomatoB = 0; // 익지 않은 토마토 개수
    for (int h = 0; h < H; h++) {
      for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine(), " ");
        for (int j = 0; j < M; j++) {
          box[i][j][h] = Integer.parseInt(st.nextToken());
          // 익은 토마토, 익지 않은 토마토 개수 세기
          if (box[i][j][h] == 1)
            tomatoA++;
          else if (box[i][j][h] == 0)
            tomatoB++;
        }
      }
    }

    if (tomatoA == N * M * H) { // 모든 토마토가 익어있는 상태
      System.out.println(0);
      return;
    }

    System.out.println(solution(N, M, H, box, tomatoA, tomatoB));
  }
}