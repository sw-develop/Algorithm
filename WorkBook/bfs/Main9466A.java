import java.util.*;
import java.io.*;

public class Main9466A {

  static int[] stu;
  static boolean[] hasTeam;

  static StringBuilder ans = new StringBuilder();

  public static boolean isValidTeam(int startStu, int n) {
    if (hasTeam[startStu])
      return true;

    List<Integer> teams = new LinkedList<>();
    teams.add(startStu);

    int idx = startStu;

    while(true) { // O(N)
      idx = stu[idx];

      if (teams.contains(idx)) { // 해당 코드의 최악의 실행 횟수가 1 + 2 + 3 + ... + N 이므로, O(N^2)
        if (idx != startStu) return false;
        for (int i : teams) // O(N^2)
          hasTeam[i] = true;
        return true;
      }

      teams.add(idx);
    }
  }

  public static void solution(int n) {
    int cnt = 0; // 팀에 속하지 못한 학생 수

    hasTeam = new boolean[n + 1]; // 배열 초기화
    for (int i = 1; i <= n; i++) {
      if (!isValidTeam(i, n)) // 팀을 이루는지 확인
        cnt += 1;
    }

    ans.append(cnt).append('\n');
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    while (T-- > 0) {
      int n = Integer.parseInt(br.readLine());
      String[] str = br.readLine().split(" ");
      stu = new int[n + 1]; // 배열 초기화
      for (int i = 1; i <= n; i++)
        stu[i] = Integer.parseInt(str[i - 1]);
      solution(n);
    }

    System.out.println(ans);
  }
}

/* 문제 회고

주어진 입력값 n = 100,000이므로, O(N) or O(NlogN)으로 처리했어야 함
해당 풀이는 시간복잡도 O(N^2)이므로 시간초과임

*/