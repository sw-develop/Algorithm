//[기초-산술연산] 문자 1개 입력받아 다음 문자 출력하기

//String -> char -> +1 해서 다음 문자

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class main_1041{
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //주의) char+int -> int+int (자료형 크기가 더 큰 자료형으로)
    char val = br.readLine().charAt(0);

    System.out.println(++val); //다음 문자 출력하기 
  }
}