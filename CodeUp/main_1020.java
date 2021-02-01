//주민번호 입력받아 형태 바꾸기
//입력) 000907-1121112 출력) 0009071121112

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

class main_1020{
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), "-");

    while(st.hasMoreTokens())
      System.out.print(st.nextToken());

  }
}