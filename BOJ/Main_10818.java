import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main_10818 {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] arr = new int[Integer.parseInt(br.readLine())]; //배열 선언 및 생성 

    StringTokenizer st = new StringTokenizer(br.readLine(), " "); //문자열을 토큰으로 분리
    for(int i = 0; i<arr.length; i++)
      arr[i] = Integer.parseInt(st.nextToken());
    int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

   for(int i = 0; i<arr.length; i++){
     if(arr[i] > max) max = arr[i];
     if(arr[i] < min) min = arr[i];
   }

    System.out.printf("%d %d", min, max);
}
}