import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main_10818 {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int count = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine(), " "); 

    int max = Integer.parseInt(st.nextToken());
    int min = max;
    int val = 0;

    while(st.hasMoreTokens()){
      val = Integer.parseInt(st.nextToken());
      if(val > max) max = val;
      else if(val < min) min = val;
    }

    System.out.printf("%d %d", min, max);
}
}