//[기초-산술연산] 정수 2개 입력받아 합 출력하기2

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class main_1039{
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " "); //공백 기준으로 토큰으로 분리

  //long 변수에 값 저장하기 위해서는 Long 클래스의 parseLong() 메서드 사용 
    long a = Long.parseLong(st.nextToken());
    long b = Long.parseLong(st.nextToken());

    System.out.println(a+b);
  }
}