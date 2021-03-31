//사용자료구조 : 문자열 처리 
import java.io.*;
import java.util.*;

public class Main_2884{
  public static void main(String[] args){
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int hour = Integer.parseInt(st.nextToken());
    int minute = Integer.parseInt(st.nextToken());

    int time = minute - 45; //45분 전 

    if(time >= 0){ 
      minute = time;
    }
    else{
      if(hour == 0) hour = 23;
      else hour--;
      minute = 60 + time;
    }

    System.out.printf("%d %d", hour, minute);
  }
}