//[기초-산술연산] 정수 2개 입력받아 나눈 나머지 출력하기

//% 연산자 사용

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class main_1043{
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " "); //공백을 기준으로 토큰으로 나누기

    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    System.out.println(a%b);
  }
}

