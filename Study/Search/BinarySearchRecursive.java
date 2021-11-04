import java.util.*;

public class BinarySearchRecursive {
  public static int binarySearch(int[] arr, int target, int start, int end){
    if (start > end) return -1; // 재귀 끝날 조건

    int mid = (start+end)/2; // mid에 나눈 몫이 저장됨 
    // 경우1. 해당 원소 찾은 경우 (인덱스 반환)
    if (arr[mid] == target) return mid;
    // 경우2. 중간점의 값보다 찾고자 하는 값이 작은 경우 (왼쪽 확인)
    else if (arr[mid] > target) return binarySearch(arr, target, start, mid-1);
    // 경우3. 중간점의 값보다 찾고자 하는 값이 큰 경우 (오른쪽 확인)
    else return binarySearch(arr, target, mid+1, end);
  }

  public static void main(String[] args){
    Scanner kbd = new Scanner(System.in);

    // 원소의 개수와 찾고자 하는 값 입력받기
    int count = kbd.nextInt();
    int target = kbd.nextInt();

    // 전체 원소 입력받기
    int[] arr = new int[count];
    for(int i = 0; i < count; i++){
      arr[i] = kbd.nextInt();
    }

    // 이진 탐색 수행 결과 출력
    int targetIndex = binarySearch(arr, target, 0, count-1); // 0 : 시작점, n-1 : 끝점
    if(targetIndex == -1){
      System.out.println("원소가 존재하지 않습니다.");
    }
    else{
      System.out.println(targetIndex + 1);
    }

  }
}