import java.util.*;
import java.io.*;

public class Main11399A {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] time = new int[N];
    String[] str = br.readLine().split(" ");
    for (int i = 0; i < N; i++)
      time[i] = Integer.parseInt(str[i]);

    Arrays.sort(time); // 오름차순 정렬

    // 여기 계산 주의!
    int ans = 0;
    int tmp = 0;
    for (int i : time) {
      tmp += i;
      ans += tmp;
    }
    System.out.println(ans);
  }
}