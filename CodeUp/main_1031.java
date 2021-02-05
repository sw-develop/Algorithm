//[기초-출력변환] 10진 정수 1개 입력받아 8진수로 출력하기

//문자열 입력 받음 -> 정수 변환 -> 8진수로 출력변환

import java.io.InputStreamReader;
import java.io.BufferedReader;

public class main_1031{
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int val = Integer.parseInt(br.readLine());

    System.out.printf("%o", val); //8진수로 출력 
  }
}