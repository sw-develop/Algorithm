//실수 1개 입력받아 부분별로 출력하기
//입력) 1.414213 출력) 1 414213

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

class main_1023{
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), "."); //문자열 입력 받고 . 을 기준으로 토큰으로 나누기

    System.out.print(st.nextToken() + "\n" + st.nextToken());

  }
}
