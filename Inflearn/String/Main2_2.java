import java.util.Scanner;

public class Main2_2 {

  public static String solution(String str) {
    StringBuilder output = new StringBuilder();
    for(char c : str.toCharArray()) {
      if (Character.isUpperCase(c)) {
        output.append(Character.toLowerCase(c)); //대문자 -> 소문자
      } else {
        output.append(Character.toUpperCase(c)); //소문자 -> 대문자
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