import java.util.*;

class Main {
  public static Long result = 1L;
  public static String resultStr;
  public static int[] counts = new int[10];

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);

    for(int i = 0; i < 3; i++) {
      result *= kbd.nextInt();
    }

    resultStr = result.toString();

    for(int i = 0; i < resultStr.length(); i++) {
      int index = Integer.parseInt(String.valueOf(resultStr.charAt(i)));
      counts[index]++;
    }

    for(int count : counts) {
      System.out.println(count);
    }

  }
}