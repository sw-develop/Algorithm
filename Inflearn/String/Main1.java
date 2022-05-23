//문제이름: 문자 찾기

import java.util.*;
  
public class Main1 {

  public static int solution(String str, char c) {
    int result = 0;
    //대문자로 모두 변경 (비교하기 쉽도록)
    str = str.toUpperCase();
    c = Character.toUpperCase(c);
    //비교
    for (char x : str.toCharArray()) {
      if (x == c) result++;
    }

    return result;
  }
  
  public static void main(String[] args){
    Scanner kbd=new Scanner(System.in);

    String str = kbd.next();
    char c = kbd.next().charAt(0);

    System.out.println(solution(str, c));
  }
}