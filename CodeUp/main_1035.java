// [기초-출력변환] 16진 정수 1개 입력받아 8진수로 출력하기

//문자열로 입력 받음 -> 16진수로 인식하고 8진수로 출력해줘야함
//문자열 -> 16진수 -> 10진수 -> 8진수 ? 

import java.io.InputStreamReader;
import java.io.BufferedReader;

public class main_1035{
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int val = Integer.parseInt(br.readLine(), 16); // 입력값을 16진수로 인지하고 -> 10진수로 저장
    
    System.out.printf("%o", val); //8진수 형태로 출력 
  }
}