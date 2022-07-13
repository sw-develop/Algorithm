import java.util.*;

public class Main6A {

  public static int[] check = new int[100001];

  public static void setPrimeNumCheck() {
    int maxNum = 100000;
    check[1] = 1; //1은 소수가 아님
    for (int i = 2; i <= maxNum; i++) {
      if (check[i] == 0) { //소수이면
        for (int j = i + i; j <= maxNum; j += i) check[j] = 1;
      }
    }
  }
  
  public static List<Integer> solution(int[] input) {
    //숫자 뒤집기
    int[] reverse = new int[input.length];
    for(int i = 0; i < input.length; i++) {
      int num = input[i];
      String reverseNum = new StringBuilder(String.valueOf(num)).reverse().toString();
      reverse[i] = Integer.valueOf(reverseNum);
    }
    //소수 판별
    setPrimeNumCheck();
    List<Integer> output = new ArrayList<>();
    for (int i : reverse) {
      if (check[i] == 0) {
        output.add(i);
      }
    }
    return output;
  }
  
  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    int N = kbd.nextInt();
    int[] input = new int[N];
    for(int i = 0; i < N; i++) {
      input[i] = kbd.nextInt();
    }
    for(int i : solution(input)) {
      System.out.print(i + " ");
    }
  }
}