//년월일 입력 받아 형식 바꿔 출력하기
//입력) 2014.07.15 출력) 15-07-2014 

//새로 사용한 함수) public String[] split(String regex); -> 문자열을 정규식(regex)에 맞춰서 분리함
//방법) 문자열로 입력 받기 -> .을 기준으로 문자열 나누기 -> 순서대로 배열에 저장 -> 마지막 인덱스 값부터 출력해주기 

//주의) 메타문자를 구분자로 사용하려면, 이스케이프 문자 "\\"을 앞에 붙여줘야함!
//->정규표현식에서 .은 하나의 문자와 대응하는 일종의 메타문자임!

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
 
public class main_1027_split{
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String str = br.readLine();
    String[] val = str.split("\\."); //메타문자를 구분자로 사용하기 

    System.out.printf("%02d-%02d-%04d", Integer.parseInt(val[2]), Integer.parseInt(val[1]), Integer.parseInt(val[0]));

  }
}