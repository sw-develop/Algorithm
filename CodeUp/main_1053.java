//[기초-논리연산] 참 거짓 바꾸기
//1(true, 참) 또는 0(false, 거짓) 이 입력되었을 때 반대로 출력하는 프로그램을 작성

//사용 연산자) 논리연산자 ! 

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class main_1053{
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    boolean val = Boolean.parseBoolean(br.readLine());

    //System.out.printf("%d", (!val) ? 1 : 0);
    
    System.out.println(!val);
    System.out.println(val);
  }
}