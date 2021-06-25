//N : 배열의 크기, M : 숫자가 더해지는 횟수, K : 연속 가능 횟수 
//범위: 1이상 10000이하 

import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

class q1 {
    public static void main(String args[]){
      //주어진 배열 내림차순 정렬 -> 큰 수부터 k번씩 더하기
      Scanner kbd = new Scanner(System.in);
      int N, M, K;
      int count = 0; 

      System.out.println("N, M, K :");
      N = kbd.nextInt();
      M = kbd.nextInt();
      K = kbd.nextInt();

      int arr[] = new int[N];
      for(int i = 0; i < N; i++)
        arr[i] = kbd.nextInt();
      
      Arrays.sort(arr); //내림차순 정렬 
      //가장 큰 수 2개만 필요함 
      if(M % K == 0) { //나눠떨어질 때 
    	  count += arr[N-1]*(M/K/2)*K;
    	  count += arr[N-2]*(M/K/2)*K;
      }
      else { //나눠떨어지지 않을 때 
    	  count += arr[N-1]*(M/K)*K;
    	  count += arr[N-2]*(M%K);
      }
      
      System.out.println(count);

    }
}