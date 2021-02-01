//단어 1개 입력받아 나누어 출력하기

//방법: String 클래스 메서드 사용하기(charAt(), length())

import java.io.InputStreamReader;
import java.io.BufferedReader;

class main_1024{
  public static void main(String[] args) throws Exception{
      //문자열 입력을 위한 객체 선언
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      String val = br.readLine(); //입력값을 val 변수에 저장

      //한 문자씩 출력하기 
      for(int i = 0; i<val.length(); i++)
        System.out.println("'" + val.charAt(i) + "'");

  }
}