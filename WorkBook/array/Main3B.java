import java.io.*;

public class Main3B {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] input = new int[n];
    String[] str = br.readLine().split(" ");
    for (int i = 0; i < n; i++)
      input[i] = Integer.parseInt(str[i]);
    int x = Integer.parseInt(br.readLine());

    int ans = 0;
    boolean[] occur = new boolean[2000001];
    for (int i = 0; i < n; i++) {
      // x - input[i] 존재여부 확인
      if (x - input[i] > 0 && occur[x - input[i]])
        ans++;
      occur[input[i]] = true;
    }

    System.out.println(ans);
  }
}