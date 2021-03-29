//문제 : 랜덤 수 정렬하기
//난수 발생 2가지
//1)java.lang.Math 클래스의 정적메소드인 random()사용
//2)java.util.Random 클래스 사용
import java.util.Random;

public class ArrayEx7{
  public static int[] makeArray(int n){
    int[] arr = new int[n]; //배열 선언 및 생성
    return arr;
  }
  
  //랜덤수 만들기1 : 0~100까지
  public static void setArray_random(int[] arr){
    for(int i = 0; i < arr.length; i++)
      arr[i] = (int)(Math.random()*1000)*101; //나머지 값 0~100
  }

  //랜덤수 만들기2 : start~end까지
  public static void setArray_random2(int[] arr, int start, int end){
    int[] check = new int[end-start+1]; //중복 수 체크하는 배열 -> 나온 값 : 1, 아직 안 나온 값: 0
    Random r = new Random();

    for(int i = 0; i<arr.length;){ //조건식 생략
      arr[i] = r.nextInt(end-start+1) + start; //start~end까지의 수 중 하나
      if(check[arr[i]-start-1] == 0) { //이전에 나온 값이 아닐 때
        check[arr[i]-start-1] = 1;
        i++;
      }
    }

  }
  public static void sortArray(int[] arr){ //버블정렬
    for(int i = arr.length-2; i>0; i--){
      for(int j = 0; j<=i; j++){
        if(arr[j] > arr[j+1]){ //값 정렬 
          int temp = arr[j+1];
          arr[j+1] = arr[j];
          arr[j] = temp;
        }
      }
    }
  }
  public static void printArray(int[] arr){
    for(int i = 0; i < arr.length; i++)
      System.out.printf("arr[%d] : %d\n", i, arr[i]);
  }
  public static void main(String[] args){
    int[] arr = makeArray(10);

    setArray_random2(arr, 20, 40);

    System.out.println("[before sort]");
    printArray(arr);

    System.out.println("\n[after sort]");
    sortArray(arr);
    printArray(arr);

  }
}