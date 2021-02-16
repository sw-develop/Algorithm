import java.util.Scanner;

class MaxOfArray{
  //전달받은 배열의 최대값을 구해 반환하는 메서드
  static int maxOf(int[] a){
    int max = a[0]; //배열의 첫 원소를 max라고 설정하고 시작

    for(int i = 1; i<a.length; i++)
      if(a[i] > max) max = a[i];

    return max;
  }
  public static void main(String[] args){
    Scanner kbd = new Scanner(System.in);

    System.out.print("사람 수 : ");
    int num = kbd.nextInt();

    int[] height = new int[num];//길이가 num인 배열 생성

    //배열 원소 값 입력받기
    for(int i = 0; i<height.length; i++){
      System.out.printf("height[%d] : ", i);
      height[i] = kbd.nextInt();
      System.out.println();
    }
    
    System.out.println(maxOf(height));
  }
}