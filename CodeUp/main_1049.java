//[기초-비교연산] 두 정수 입력받아 비교하기

//비교/관계연산자는 >, <, >=, <=, ==(같다), !=(다르다) 6개

//string -> int -> 비교연산

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main_1049{
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    //System.out.println(a>b); -> true, false 로 나옴
    System.out.printf("%d", (a>b) ? 1 : 0); //삼항연산자 사용(bool->int);
  }
}