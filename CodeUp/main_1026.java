//시분초 입력받아 분만 출력하기
//입력) 17:23:57
//출력) 23

//방법) 문자열로 입력 받아 :을 기준으로 분리한 뒤 2번째 토큰 출력하기

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class main_1026{
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), ":");
    st.nextToken();
    System.out.println(Integer.parseInt(st.nextToken())); //00 입력 시 0으로 출력되게 하기 위해 String -> int 형변환해서 출력
  }
}