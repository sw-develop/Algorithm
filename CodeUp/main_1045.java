//[기초-산술연산] 정수 2개 입력받아 자동 계산하기

//정수 2개(a, b)를 입력받아 합, 차, 곱, 몫, 나머지, 나눈 값을 자동으로 계산해보자.
//단 0 <= a, b <= 2147483647, b는 0이 아니다.

//string으로 입력 받기 -> 토큰으로 분리 -> 연산

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class main_1045{
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " "); //공백을 기준으로 토큰으로 분리하기 

    long a = Long.parseLong(st.nextToken());
    long b = Long.parseLong(st.nextToken());

    System.out.printf("%d\n%d\n%d\n%d\n%d\n%.2f\n", a+b, a-b, a*b, a/b, a%b, (double)a/b);


  }
}