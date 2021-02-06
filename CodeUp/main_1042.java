//[기초-산술연산] 정수 2개 입력받아 나눈 몫 출력하기

//문자열 -> 정수 
//정수/정수 = 정수 

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class main_1042{
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " "); //공백을 기준으로 토큰으로 나누기

    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    System.out.println(a/b);
  }
}