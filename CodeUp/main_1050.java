// [기초-비교연산] 두 정수 입력받아 비교하기

//두 정수(a, b)를 입력받아 a와 b가 같으면 1을, 같지 않으면 0을 출력하는 프로그램을 작성

//string -> int -> 비교연산 (삼항연산자 사용 bool -> int)

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main_1050{
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    System.out.printf("%d", (a==b) ? 1 : 0); //삼항연산자 사용


  }
}