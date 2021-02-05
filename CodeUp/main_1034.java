// [기초-출력변환] 8진 정수 1개 입력받아 10진수로 출력하기

//문자열 입력받기 -> 입력받은 8진수를 10진수로 변환 : Integer.parseInt(String s, int radix) 

import java.io.InputStreamReader;
import java.io.BufferedReader;

public class main_1034{
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int val = Integer.parseInt(br.readLine(), 8);//입력값(String)을 8진수로 인지하고 -> 10진수로 변환하여 저장 

    System.out.println(val); 
  }
}