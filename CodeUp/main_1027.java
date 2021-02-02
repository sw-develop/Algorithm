//년월일 입력 받아 형식 바꿔 출력하기
//입력) 2014.07.15 출력) 15-07-2014 

//방법) 문자열로 입력 받기 -> .을 기준으로 토큰으로 나누기 -> 순서대로 배열에 저장 -> 마지막 인덱스 값부터 출력해주기 

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class main_1027{
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), "."); //.을 기준으로 토큰으로 나누기 

    int[] val = new int[3];
    for(int i = 0; i<val.length; i++)
      val[i] = Integer.parseInt(st.nextToken()); //String->int 형변환 후 배열에 저장

    System.out.printf("%02d-%02d-%04d", val[2], val[1], val[0]);

  }
}