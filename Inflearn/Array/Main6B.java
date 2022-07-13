import java.util.*;

public class Main6B {

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
    setPrimeNumCheck();
    List<Integer> output = new ArrayList<>();
    for(int i = 0; i < input.length; i++) { //숫자 뒤집기
      int tmp = input[i];
      int res = 0;
      while(tmp > 0) {
        int t = tmp % 10;
        res = res * 10 + t;
        tmp /= 10;
      }
      if (check[res] == 0) output.add(res); //소수 판별
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