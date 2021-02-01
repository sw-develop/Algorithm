//년, 월, 일 입력받아 지정된 형식으로 출력하기
//입력) 2013.6.13 출력)2013.06.13
//Scanner 대신 BufferedReader 사용하기

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

class main_1019_bfr{
  public static void main(String[] args) throws Exception{ //예외처리 필수!
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //br 객체 선언

      StringTokenizer st = new StringTokenizer(br.readLine(), "."); //문자열 입력 후 . 을 기준으로 토큰으로 나누기

      System.out.printf("%04d.%02d.%02d", Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
  }
}