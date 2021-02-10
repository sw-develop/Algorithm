//[기초-논리연산] 참 거짓 바꾸기
//1(true, 참) 또는 0(false, 거짓) 이 입력되었을 때 반대로 출력하는 프로그램을 작성

//사용 연산자) 논리연산자 ! 
//사용 함수) 
//String 클래스의 equals 함수 : boolean equals(Object anobject)

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class main_1053{
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //자바에서는 true 라고 입력되어야지만 bool 값으로 true라고 저장됨 
    boolean val = "1".equals(br.readLine());
     
    System.out.printf("%d", (!val) ? 1 : 0); //bool->int 표현

    
  }
}