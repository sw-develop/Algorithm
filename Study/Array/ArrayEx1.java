//Q. 양수 5개를 입력 받아 배열에 저장하고, 제일 큰 수를 출력하는 프로그램 작성하기(0미만의 수는 저장하지 않음)

//알게된 내용) 
//for문 증감식 생략 가능 -> for문 내에서 따로 조건을 줘야 무한루프에 빠지지 않음

import java.util.Scanner;

public class ArrayEx1{
  public static void main(String[] args){
    Scanner kbd = new Scanner(System.in);
    int[] arr = new int[5]; //배열 선언 및 생성
    int max = 0, value;

    System.out.println("Input 5 numbers");

    for(int i = 0; i<arr.length;){
      value = kbd.nextInt();
      if(value < 0) { //입력값이 음수일 때
        System.out.println("wrong input!");
        continue;
      }
      arr[i] = value;
      if(arr[i] > max) max = arr[i]; 
      i++; //for문 조건식 
    }
   
    System.out.println("Max Num : " + max);
  }
}

