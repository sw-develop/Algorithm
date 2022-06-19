import java.util.Scanner;

public class Main2_1 {

  public static String solution(String str) {
    StringBuilder output = new StringBuilder();
    for (char c : str.toCharArray()) {
      if (65 <= c && c <= 90) { //아스키코드 사용
        output.append((char)(c + 32)); //대문자 -> 소문자
      } else {
        output.append((char)(c - 32)); //소문자 -> 대문자
      }
    }
    return output.toString();
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    String input = kbd.next();
    System.out.println(solution(input));
  }
}