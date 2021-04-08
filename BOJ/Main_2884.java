//사용자료구조 : 문자열 처리 
import java.io.*;

public class Main_2884{
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] arr = br.readLine().split(" ");

    int hour = Integer.parseInt(arr[0]);
    int minute = Integer.parseInt(arr[1]);

    int time = minute - 45; //45분 전 

    if(time >= 0){ //시가 바뀌지 않을 때 
      minute = time;
    }
    else{ //시가 바뀔 때 
      hour = (hour==0 ? 23 : hour-1); //삼항연산자 
      minute = 60 + time;
    }

    System.out.printf("%d %d", hour, minute);
  }
}