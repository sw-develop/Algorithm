// [기초-논리연산] 참/거짓이 서로 같을 때에만 참 출력하기

//생각1)xor 연산 결과의 거짓인 경우를 참으로 출력하도록 
//생각2)같은 지 비교해서(equals())

//STRING -> 토큰 분리 -> BOOLEAN 값 저장 -> 연산

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class main_1057{
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    //1을 boolean으로 인식못해서 비교함수 써주기
    boolean a = "1".equals(st.nextToken());
    boolean b = "1".equals(st.nextToken());

    System.out.printf("%d", (a^b)?0:1);

  }
}