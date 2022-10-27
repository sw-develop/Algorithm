//문자 등장 횟수 기준 내림차순 출력
//대소문자 구분

//정렬 구현
//방식1 - Comparable 인터페이스 구현
//방식2 - Java11의 stream, sorted, forEach 사용

import java.util.*;

class DataA implements Comparable<DataA> {
  char c;
  int cnt;

  public DataA(char c, int cnt) {
    this.c = c;
    this.cnt = cnt;
  }

  @Override
  public int compareTo(DataA o) { // cnt 기준 내림차순
    return o.cnt - this.cnt;
  }
}

public class Main1A {

  public static String solution(String str) {
    StringBuilder ans = new StringBuilder();

    Map<Character, Integer> hm = new HashMap<>();
    for (char c : str.toCharArray()) {
      int cnt = hm.getOrDefault(c, 0);
      hm.put(c, cnt + 1);
    }

    List<DataA> list = new LinkedList<>();
    for (char c : hm.keySet()) {
      list.add(new DataA(c, hm.get(c)));
    }

    Collections.sort(list);

    for (DataA d : list) {
      ans.append(d.c);
    }

    return ans.toString();
  }

  public static void main(String[] args) {
    System.out.println(solution("banana"));
  }
}