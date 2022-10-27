//문자 등장 횟수 기준 내림차순 출력
//대소문자 구분

//정렬 구현
//방식1 - Comparable 인터페이스 구현
//방식2 - Java11의 stream, sorted, forEach 사용

import java.util.*;

class DataB {
  char c;
  int cnt;

  public char getC() {
    return this.c;
  }

  public int getCnt() {
    return this.cnt;
  }

  public DataB(char c, int cnt) {
    this.c = c;
    this.cnt = cnt;
  }
}

public class Main1B {

  public static String solution(String str) {
    StringBuilder ans = new StringBuilder();

    Map<Character, Integer> hm = new HashMap<>();
    for (char c : str.toCharArray()) {
      int cnt = hm.getOrDefault(c, 0);
      hm.put(c, cnt + 1);
    }

    List<DataB> list = new LinkedList<>();
    for (char c : hm.keySet()) {
      list.add(new DataB(c, hm.get(c)));
    }

    list.stream().sorted(Comparator.comparing(DataB::getCnt).reversed()).forEach(data -> ans.append(data.getC()));

    return ans.toString();
  }

  public static void main(String[] args) {
    System.out.println(solution("banana"));
  }
}