//N : 배열의 크기, M : 숫자가 더해지는 횟수, K : 연속 가능 횟수 
//범위: 1이상 10000이하 

import java.util.Scanner;
import java.util.Arrays;

class q1 {
    public static void main(String args[]){
      //주어진 배열 내림차순 정렬 -> 큰 수부터 k번씩 더하기
      Scanner kbd = new Scanner(System.in);
      int N, M, K;
      int count = 0, result = 0; 

      //N(배열의 크기), M(더해지는 횟수), K(연속 가능 횟수) 값 입력받기 
      System.out.println("N, M, K :");
      N = kbd.nextInt();
      M = kbd.nextInt();
      K = kbd.nextInt();

      //배열의 값 입력 받기 
      int arr[] = new int[N];
      for(int i = 0; i < N; i++)
        arr[i] = kbd.nextInt();
      
      Arrays.sort(arr); //내림차순 정렬 
      
      count = M/(K+1)*K + M%(K+1); //가장 큰 수 더해지는 횟수 계산 
      
      result += arr[N-1]*count; //가장 큰 수  
      result += arr[N-2]*(M-count); //2번째로 큰 수 
      
      System.out.println(result);

    }
}