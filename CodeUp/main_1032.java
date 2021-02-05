//[기초-출력변환] 10진 정수 입력받아 16진수로 출력하기

//문자열로 입력 받음 -> 10진수 변환 -> 16진수로 출력

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Scanner;

public class main_1032{
  public static void main(String[] args) throws Exception{
/*
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int val = Integer.parseInt(br.readLine());

    System.out.printf("%x", val); //16진수로 출력 
*/
  Scanner kbd = new Scanner(System.in);
  int val = kbd.nextInt();
  System.out.printf("%x", val); //16진수로 출력
  }
}