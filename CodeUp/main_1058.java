//[기초-논리연산] 둘 다 거짓일 경우만 참 출력하기

//사용 논리연산) || 

//생각) || 연산 결과 거짓인 경우를 참으로 출력하기 

//string -> 토큰 분리 -> boolean 값 저장 -> 연산

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class main_1058{
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    boolean a = "1".equals(st.nextToken());
    boolean b = "1".equals(st.nextToken());

    System.out.printf("%d", (a||b)?0:1);
    System.out.printf("%d", !(a||b)?1:0);
  }
}