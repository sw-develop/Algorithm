import java.util.*;
import java.io.*;

public class Main1120A {

  public static int solution(String A, String B) {
    int answer = A.length();

    for (int i = 0; i <= B.length() - A.length(); i++) {
      int tmp = 0;
      for (int j = 0; j < A.length() - 1; j++) {
        if (A.charAt(j) != B.charAt(j + i))
          tmp++;
      }
      answer = Math.min(answer, tmp);
    }

    return answer;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    System.out.println(solution(input[0], input[1]));
  }
}