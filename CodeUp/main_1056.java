//[기초-논리연산] 참/거짓이 서로 다를 때에만 참 출력하기

//두 가지의 참(1) 또는 거짓(0)이 입력될 때, 참/거짓이 서로 다를 때에만 참을 출력하는 프로그램을 작성 

//사용 논리연산) XOR(배타적 논리합)연산 -> 집합의 의미로는 합집합-교집합

//표현1)XOR = (a&&!b)||(!a&&b)
//표현2)bitwise 연산자 ^

//입력) 1 1 출력) 0

//string -> 토큰 분리 -> boolean 값 저장 -> 논리연산

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class main_1056{
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    boolean a = "1".equals(st.nextToken());
    boolean b = "1".equals(st.nextToken());

    System.out.printf("%d\n", ((a&&!b)||(!a&&b))?1:0);
    System.out.printf("%d", (a^b)?1:0);
  }
}

