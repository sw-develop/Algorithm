//[기초-논리연산] 둘 다 참일 경우만 참 출력하기

//두 개의 참(1) 또는 거짓(0)이 입력될 때, 모두 참일 때에만 참을 출력하는 프로그램을 작성

//사용 논리연산자 : &&

//입력) 1 1 출력) 1

//string -> 토큰 분리 -> boolean 값으로 저장 -> 논리 연산

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class main_1054{
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    //1 입력 시 true라고 저장
    boolean a = "1".equals(st.nextToken());
    boolean b = "1".equals(st.nextToken());

    //논리 연산 & 삼항연산자 적용 
    System.out.printf("%d", (a&&b)?1:0);

  }
}