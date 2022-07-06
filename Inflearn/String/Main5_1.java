import java.util.*;

public class Main5_1 {

  public static String solution(String input) {
    char[] charArr = input.toCharArray();
    int left = 0;
    int right = charArr.length - 1;

    while(left < right) {  
      if (charArr[left] < 65 || charArr[left] > 122) {
        left++;
      } else if (charArr[right] < 65 || charArr[right] > 122) {
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