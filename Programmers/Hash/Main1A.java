import java.util.*;

class Solution {
  public boolean solution(String[] phone_book) {

    // 길이 오름차순 정렬
    List<String> input = new LinkedList<>();
    for (String s : phone_book) {
      input.add(s);
    }

    Collections.sort(input, new Comparator<String>() { // 익명클래스로 Comparator 객체 생성
      @Override
      public int compare(String s1, String s2) {
        return s1.length() - s2.length();
      }
    });

    // 수행
    HashSet<String> hs = new HashSet<>();
    for (String s : input) {
      for (int i = 1; i <= s.length(); i++) {
        String tmp = s.substring(0, i);
        if (hs.contains(tmp))
          return false;
      }
      hs.add(s);
    }

    return true;
  }
}