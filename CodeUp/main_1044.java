//[기초-산술연산] 정수 1개 입력받아 1 더해 출력하기

//1 더한 후 정수 자료형 주의! int -> long 확장 필요

import java.io.InputStreamReader;
import java.io.BufferedReader;

public class main_1044{
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //이렇게 하면 int+int 이므로 이미 int 범위가 넘어가버림!
    //long val = Integer.parseInt(br.readLine()) + 1;

    //연산 할 때 long으로 변환해서 연산해줘야 함! 
    //long + int -> long + long 
    long val = Long.parseLong(br.readLine()) + 1;

    System.out.println(val);    
  }
}