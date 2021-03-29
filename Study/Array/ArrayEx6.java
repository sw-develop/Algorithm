//배열 리턴
//makeArray() : 전달받은 정수 n개를 가지는 일차원 배열 생성, 1~n으로 초기화한 후 리턴하는 메서드 

public class ArrayEx6{
  public static int[] makeArray(int n){ 
    int[] arr = new int[n]; //1차원 배열 선언 및 생성
    for(int i = 0; i<arr.length; i++)
      arr[i] = i+1; //배열 초기화 
    return arr;
  }
  public static void main(String[] args){
    int n = 5;
    int[] arr = makeArray(n);

    for(int i = 0; i<arr.length; i++)
      System.out.printf("arr[%d] : %d\n", i, arr[i]);

  }
}