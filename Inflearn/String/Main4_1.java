//14M 30S

import java.util.Scanner;

class Main4_1 {

  public static String solution(String str) { //문자열 뒤집기
    char[] charArr = str.toCharArray();
    int left = 0;
    int right = charArr.length - 1;
    while (left < right) {
      char tmp = charArr[left];
      charArr[left] = charArr[right];
      charArr[right] = tmp;
      left++; right--;
    }
    return new String(charArr);
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);

    int N = kbd.nextInt();
    String[] input = new String[N];
    for (int i = 0; i < N; i++) {
      input[i] = kbd.next();
    }

    for (String s : input) {
      System.out.println(solution(s));
    }
  }
}