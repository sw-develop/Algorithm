// Disjoint Set(서로소 집합) & Union-Find 알고리즘

import java.util.*;

public class Main6B {

  static int[] unf;

  public static int find(int v) { // 특정 원소가 속한 집합 찾기
    if (v == unf[v]) return v;
    return unf[v] = find(unf[v]); //경로 압축을 위함
  }

  public static void union(int a, int b) { //두 원소가 속한 집합 합치기
    int fa = find(a);
    int fb = find(b);
    if (fa != fb) unf[fa] = fb;
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    int N = kbd.nextInt();
    int M = kbd.nextInt();
    
    unf = new int[N + 1];
    for (int i = 1; i <= N; i++) // 집합 초기화 - 자기 자신만을 원소로 가짐
      unf[i] = i;
    for (int i = 1; i <= M; i++) {
      int a = kbd.nextInt();
      int b = kbd.nextInt();
      union(a, b);
    }
    
    int a = kbd.nextInt();
    int b = kbd.nextInt();
    int fa = find(a);
    int fb = find(b);
    if (fa == fb) System.out.println("YES");
    else System.out.println("NO");
  }
}

