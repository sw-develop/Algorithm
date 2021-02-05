//[기초-산술연산] 정수 2개 입력받아 합 출력하기1

//정수 2개를 입력받아 합을 출력하는 프로그램을 작성해보자.
//(단, 입력되는 정수는 -1073741824 ~ 1073741824 이다.)

//문자열 입력 -> 공백기준 토큰으로 분리 -> int로 형변환 -> 연산(int 범위 주의!)

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class main_1038{
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " "); //공백 기준으로 토큰으로 분리

    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    //주의 상황) 계산의 결과가 int 범위를 넘는 경우가 있으므로, long으로 형변환하여 연산수행해야 함 
    long val = (long)a+b;

    System.out.println(val);
  }
}
