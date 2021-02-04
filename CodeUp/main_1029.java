//실수 1개 입력받아 그대로 출력하기2
//입력된 실수를 소수점 이하 11자리까지 반올림하여 출력한다.

import java.io.InputStreamReader;
import java.io.BufferedReader;

public class main_1029{
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    double val = Double.parseDouble(br.readLine());
    System.out.printf("%.11f", val);
  }
}