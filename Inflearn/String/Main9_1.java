import java.util.*;

public class Main9_1 {

  public static Long solution(String input) {
    input = input.replaceAll("[^0-9]", ""); //필요 데이터만 추출
    return Long.parseLong(input); //데이터 처리
  }
  
  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    String input = kbd.next();
    System.out.println(solution(input));
  }
}