//[기초-비트단위논리연산] 비트단위로 AND 하여 출력하기

//입력된 정수 두 개를 비트단위로 and 연산한 후 그 결과를 정수로 출력해보자

//사용) 비트단위 연산자 &

//string -> 토큰 분리 -> 정수 저장 -> 논리 연산

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class main_1060{
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    System.out.printf("%d", a&b);
  }
}