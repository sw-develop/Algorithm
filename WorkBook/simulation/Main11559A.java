import java.util.*;
import java.io.*;

public class Main11559A {

  static char[][] map = new char[12][6];
  static int answer = 0;

  static int[] dx = {-1, 1, 0, 0}; //상하좌우
  static int[] dy = {0, 0, -1, 1}; 
  
  public static boolean check(int i, int j) {
    List<int[]> list = new LinkedList<>();

    boolean[][] visited = new boolean[12][6];
    
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[]{i, j});
    visited[i][j] = true;
    while (!q.isEmpty()) { //BFS 수행
      int[] arr = q.poll();
      int x = arr[0];
      int y = arr[1];
      list.add(new int[]{x, y});
      for (int k = 0; k < dx.length; k++) {
        int nx = x + dx[k];
        int ny = y + dy[k];
        if (nx < 0 || nx >= 12 || ny < 0 || ny >= 6) continue;
        if (!visited[nx][ny] && map[nx][ny] == map[x][y]) {
          q.offer(new int[]{nx, ny});
          visited[nx][ny] = true;
        }
      }
    }

    if (list.size() < 4) return false;
    for (int[] arr : list) {
      map[arr[0]][arr[1]] = '.';
    }
    return true;
  }

  public static boolean isPop() {
    //조건
    //같은 색 뿌요가 4개 이상 상하좌우로 연결 => 연결된 뿌요가 4개 이상이면 pop?!
    boolean isAvailable = false;
    for (int i = 0; i < 12; i++) {
      for (int j = 0; j < 6; j++) {
        if (map[i][j] != '.') {
          if (check(i, j)) //4개 이상 연결되어 있을 때
            if (!isAvailable) isAvailable = true;
        }
      }
    }
    return isAvailable;
  }

  public static void down() {
    //열 기준 한 줄씩 내리기 수행
    for (int j = 0; j < 6; j++) {
      int idx = 11;
      for (int i = 11; i >= 0; i--) {
        if (map[i][j] != '.') {
          if (idx != i) {
            map[idx][j] = map[i][j];
            map[i][j] = '.';  
          }
          idx -= 1;
        }
      }
    }
  }

  public static void printStatus() {
    for (int i = 0; i < 12; i++) {
     for (int j = 0; j < 6; j++)
        System.out.print(map[i][j]);
      System.out.println(); 
    }
  }
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    for (int i = 0; i < 12; i++) {
      String str = br.readLine();
      for (int j = 0; j < 6; j++)
        map[i][j] = str.charAt(j);
    }

    while(true) {
      if (!isPop()) // 연쇄
        break;
      answer += 1;      
      down(); // 내리기
    }

    System.out.println(answer);
  }
}