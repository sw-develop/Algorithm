import java.util.*;

class Main4_2 {

  public static ArrayList<String> solution(String[] str) {
    ArrayList<String> answer = new ArrayList<>();
    for (String s : str) {
      String tmp = new StringBuilder(s).reverse().toString();
      answer.add(tmp);
    }
    return answer;
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);

    int N = kbd.nextInt();
    String[] str = new String[N];
    for (int i = 0; i < N; i++) {
      str[i] = kbd.next();
    }

    for (String s : solution(str)) {
      System.out.println(s);
    }
  }
}