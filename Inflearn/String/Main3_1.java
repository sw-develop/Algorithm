//15M 40S

import java.util.*;

class Main3_1 {

  public static String solution(String str) {    
    String[] result = str.split(" ");

    String answer = "";
    int lenOfWord = Integer.MIN_VALUE;
    for (String s : result) {
      if (s.length() > lenOfWord) {
        answer = s;
        lenOfWord = s.length();
      }
    }
    return answer;
  }
  
  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);

    String input = kbd.nextLine();
    System.out.println(solution(input));
  }
}