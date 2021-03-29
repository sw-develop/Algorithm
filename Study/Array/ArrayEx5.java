//Q. 비정방형 배열을 만들어 값 초기화하고 출력하기

//개념)
//비정방형 배열 - 각 행의 열의 개수가 다른 배열

public class ArrayEx5{
  public static void main(String[] args){
    int[][] arr = new int[4][]; //행의 크기만 정해서 2차원 배열 생성

    int num = 1;

    //열의 크기를 다르게 해서 1차원 배열 생성
    arr[0] = new int[3];
    arr[1] = new int[2];
    arr[2] = new int[3];
    arr[3] = new int[2];

    for(int i = 0; i<arr.length; i++)
      for(int j = 0; j<arr[i].length; j++){
        arr[i][j] = num;
        num++;
      }

    for(int i = 0; i<arr.length; i++){
      System.out.print(i + "행 : ");
      for(int j = 0; j<arr[i].length; j++)
        System.out.print(arr[i][j] + " ");
      System.out.println();
    }    
  }
}