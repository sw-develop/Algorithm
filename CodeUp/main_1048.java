// [기초-비트시프트연산] 한 번에 2의 거듭제곱 배로 출력하기

//정수 2개(a, b)를 입력받아 a를 2^b배 곱한 값으로 출력해보자.
//범위) 0 <= a <= 10, 0 <= b <= 10

//string -> 토큰 분리 -> int -> 비트연산

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main_1048{
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " "); //공백을 기준으로 토큰으로 분리하기

    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    System.out.printf("%d", a<<b);


  }
}