import java.util.*;

class Main3_2 {

  public static String solution(String str) {    
    String answer = "";
    int lenOfWord = Integer.MIN_VALUE;
    int pos;
    while ((pos = str.indexOf(" ")) != -1) {
      String tmp = str.substring(0, pos); //한 단어
      if (tmp.length() > lenOfWord) {
        lenOfWord = tmp.length();
        answer = tmp;
      }
      str = str.substring(pos + 1); //마지막 단어 처리
    }
    if (str.length() > lenOfWord) answer = str;
    return answer;
  }
  
  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);

    String input = kbd.nextLine();
    System.out.println(solution(input));
  }
}