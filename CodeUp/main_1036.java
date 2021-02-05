// [기초-출력변환] 영문자 1개 입력받아 10진수로 출력하기

//String 형태로 입력 -> char로 형변환 -> 10진수로 저장

import java.io.InputStreamReader;
import java.io.BufferedReader;

public class main_1036{
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int val = br.readLine().charAt(0); //String을 char로 변환하여 10진수로 저장 

    System.out.println(val);

  }
}