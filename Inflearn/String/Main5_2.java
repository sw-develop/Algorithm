import java.util.*;

public class Main5_2 {

  public static String solution(String input) {
    char[] charArr = input.toCharArray();
    int left = 0;
    int right = charArr.length - 1;

    while(left < right) {  
      if (!Character.isAlphabetic(charArr[left])) {
        left++;
      } else if (!Character.isAlphabetic(charArr[right])) {
        right--;
      } else {
        char tmp = charArr[left];
        charArr[left] = charArr[right];
        charArr[right] = tmp;
        left++; right--;
      }
    }
    return String.valueOf(charArr);
  }
  
  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    String input = kbd.next();
    System.out.println(solution(input));
  }
}