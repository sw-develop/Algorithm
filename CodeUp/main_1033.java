//[기초-출력변환] 10진 정수 입력받아 16진수로 출력하기2
//%d(10진수 형태)로 입력받고 %X로 출력하면 16진수(hexadecimal) 대문자로 출력

import java.io.InputStreamReader;
import java.io.BufferedReader;

public class main_1033{
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int val = Integer.parseInt(br.readLine());

    System.out.printf("%X", val); //16진수 대문자로 출력 
  }
}
