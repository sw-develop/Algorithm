import java.util.*;

public class QuickSort{

  public static void quickSort(int[] arr, int start, int end){
    if(start >= end) return; //재귀 종료 조건 - 원소가 1개인 경우 

    int pivot = start; //피벗은 첫 번째 원소로 설정
    int left = start + 1;
    int right = end;
    
    while(left <= right){
      // left - 피벗보다 큰 값을 찾을 때까지 반복  
      while(left <= end && arr[left] <= arr[pivot]) left++;
      // right - 피벗보다 작은 값을 찾을 때까지 반복 
      while(right > start && arr[right] >= arr[pivot]) right --;
      
      if(left > right){ //left와 right보다 앞섰을 때 
        int temp = arr[pivot];
        arr[pivot] = arr[right];
        arr[right] = temp;
      }
      else{
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp; 
      }
    }
    //정렬된 값 기준으로 분할된 왼쪽과 오른쪽 부분에 대해 각각 정렬 수행 - 재귀호출
    quickSort(arr, start, right - 1);
    quickSort(arr, right + 1, end);
  }

  public static void main(String[] args){
    int n = 10;
    int[] arr = {4, 6, 7, 5, 1, 3, 2, 8, 9, 0};

    quickSort(arr, 0, n - 1);

    for(int i = 0; i < n; i++)
      System.out.print(arr[i] + " ");
  } 

}