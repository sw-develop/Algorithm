import java.io.*;

public class Main1120B {

  public static int solution(String A, String B) {
    int answer = A.length();

    for (int i = 0; i <= B.length() - A.length(); i++) {
      int tmp = 0;
      for (int j = 0; j < A.length(); j++) {
        if (A.charAt(j) != B.charAt(j + i)) {
          tmp++;
        }
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

/*
 * <문제 회고>
 * 
 * 놓친 부분 
 * - 문제의 조건에서 문자열 A의 앞/뒤에 문자 추가가 가능하다고 했으니, ***A*** 이런 형태이다. 
 * - 내가 생각했던 방식은 A***, ***A만 생각한 경우였다. 즉, 모든 경우를 고려하지 않았다.
 * 
 */