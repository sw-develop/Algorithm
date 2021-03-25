//Q. 배열 원소의 평균 구하기 
//개념)
//배열의 크기 -> 배열명.length 사용하기 


import java.util.Scanner;

public class ArrayEx2{
  public static int input_values_in_array(int[] arr){
    Scanner kbd = new Scanner(System.in);
    int total = 0;
    System.out.println("Input 5 numbers");
    for(int i = 0; i<arr.length; i++){
      System.out.printf("[%d] : ", i);
      arr[i] = kbd.nextInt();
      total += arr[i];
    }
    return total;
  }

  public static void showArray(int[] arr){
    System.out.print("Array : ");
    for(int i = 0; i < arr.length; i++)
      System.out.print(arr[i] + " ");
    System.out.println();
  }

  public static void main(String[] args){
    int[] intArray = new int[5]; //배열 선언 및 생성

    int sum = input_values_in_array(intArray);
    showArray(intArray);

    System.out.printf("Total : %d\n", sum);
    System.out.printf("Average : %.1f\n", (double)sum/intArray.length);
  }
}