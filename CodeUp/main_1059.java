//[기초-비트단위논리연산] 비트단위로 NOT 하여 출력하기

//컴퓨터에 저장되는 모든 데이터들은 2진수 형태로 바뀌어 저장된다.
//0과 1로만 구성되는 비트단위들로 변환되어 저장되는데,
//양의 정수는 2진수 형태로 바뀌어 저장되고,
//음의 정수는 "2의 보수 표현"방법으로 저장된다

//그래서 int 형으로 선언된 변수에는 최소 -2147483648 을 의미하는 10000000 00000000 00000000 00000000 부터 
//최대 +2147483647 을 의미하는 01111111 11111111 11111111 11111111 로 저장될 수 있는 것

//사용)bitwise 연산자 ~

import java.io.BufferedReader;
import java.io.InputStreamReader;

class main_1059{
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    System.out.printf("%d", ~Integer.parseInt(br.readLine()));


  }
}
