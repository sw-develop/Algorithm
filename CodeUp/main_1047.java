// [기초-비트시프트연산] 정수 1개 입력받아 2배 곱해 출력하기
//정수를 2배로 곱하거나 나누어 계산해 주는 비트단위시프트연산자 <<, >>를 이용한다.

//2진수 형태로 저장되어 있는 값들을 왼쪽(<<)이나 오른쪽(>>)으로 지정한 비트 수만큼 밀어주면 2배씩 늘어나거나 반으로 줄어듦 -> 2진수 형태로 표현시 각각이 1비트씩임! 

import java.io.InputStreamReader;
import java.io.BufferedReader;

public class main_1047{
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int val = Integer.parseInt(br.readLine()); //string -> int 변환

    System.out.printf("%d", val<<1); //왼쪽 비트시프트(<<) : 오른쪽에 0이 주어진 개수만큼 추가됨(단, 32비트 넘어서 이동되는 비트는 삭제됨)
  }
}