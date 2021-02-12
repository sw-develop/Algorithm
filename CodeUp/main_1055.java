//[기초-논리연산] 하나라도 참이면 참 출력하기

//사용 논리 연산자) ||

//논리연산자 || 는 주어진 2개의 논리값 중에 하나라도 참(1) 이면 1(참)로 계산하고, 그 외의 경우에는 0(거짓) 으로 계산

//입력) 1 0 출력) 1

//string -> 토큰 분리 -> boolean 값 저장 -> 논리 연산

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main_1055{
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    boolean val = "1".equals(st.nextToken()) || "1".equals(st.nextToken());

    System.out.printf("%d", (val)?1:0);
  }
}