//[기초-산술연산] 정수 1개 입력받아 부호 바꿔 출력하기

//String -> int -> 부호 바꾸기

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class main_1040{
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int val = Integer.parseInt(br.readLine());

    System.out.println((-1)*val);
  }
}