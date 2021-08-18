import java.util.*;

public class CountingSort {

  public static final int MAX_VALUE = 9; 

  public static void main(String[] args){

    int n = 15;
    int[] arr = {7,5,4,3,2,1,6,9,8,6,4,5,3,2,0};

    // 주어진 수의 모든 범위를 포함하는 배열 선언 (모든 값은 0으로 초기화)
    int[] count = new int[MAX_VALUE + 1];

    for(int i = 0; i < n; i++){
      count[arr[i]]++; //각 데이터에 해당하는 인덱스의 값 증가  
    }

    for(int i = 0; i <= MAX_VALUE; i++){
      for(int j = 0; j < count[i]; j++)
        System.out.print(i + " ");
    }
  }

}                    