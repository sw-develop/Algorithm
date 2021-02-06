//[기초-산술연산] 정수 3개 입력받아 합과 평균 출력하기

//string -> 토큰 분리 -> int -> long

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main_1046{
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " "); //공백 기준 토큰으로 분리

    long result = Long.parseLong(st.nextToken()) + Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());

    System.out.printf("%d\n%.1f\n", result, (double)result/3);
  }
}