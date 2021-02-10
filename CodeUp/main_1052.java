// [기초-비교연산] 두 정수 입력받아 비교하기

//두 정수(a, b)를 입력받아 a와 b가 서로 다르면 1을, 그렇지 않으면 0을 출력하는 프로그램을 작성해보자.

//사용 개념) 비교/관계연산자 : 일반적인 사칙연산자처럼 주어진 두 수를 이용해 계산을 수행하고, 그 결과를 1(참), 또는 0(거짓)으로 계산해 주는 연산자

//string -> 토큰으로 분리 -> int 형변환 -> 비교연산

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main_1052{
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());


    System.out.printf("%d", (a != b) ? 1 : 0);

  }
}