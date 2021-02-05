//정수 1개 입력받아 그대로 출력하기3
//정수 1개를 입력받아 그대로 출력해보자.
//단, 입력되는 정수의 범위는
//-9,223,372,036,854,775,808 ~ +9,223,372,036,854,775,807 이다.

//문자열로 입력 받은 뒤 출력하기

import java.io.InputStreamReader;
import java.io.BufferedReader;

public class main_1030 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    System.out.println(br.readLine());
  }
}
