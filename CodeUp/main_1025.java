//정수 1개 입력받아 나누어 출력하기
//입력) 75254
//출력) [70000] [5000] [200] [50] [4] 

//문자열로 입력받아 처리하기
//새로 사용한 함수 : Character.getNumericValue(char c) -> (char->int 형변환)

import java.io.InputStreamReader;
import java.io.BufferedReader;

class main_1025{
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String val = br.readLine(); //입력값을 문자열로 저장

    int x = 10000;
    for(int i=0; i<val.length(); i++){
      int num = Character.getNumericValue(val.charAt(i)); //한 자리씩 처리하기(문자 -> int)) 
      System.out.println("[" + num*x + "]");
      x /= 10;
    }
  }
}