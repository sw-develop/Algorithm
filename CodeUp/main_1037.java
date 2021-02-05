//[기초-출력변환] 정수 입력받아 아스키 문자로 출력하기

//문자열 -> 정수 -> 문자

import java.io.InputStreamReader;
import java.io.BufferedReader;

public class main_1037{
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    char val = (char)Integer.parseInt(br.readLine());

    System.out.println(val);
  }
}
