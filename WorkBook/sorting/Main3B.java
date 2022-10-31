//BOJ 2910

//수정한 사항
//데이터 입력 시 HashMap 사용
//java stream 사용해 정렬

import java.util.*;
import java.io.*;

public class Main3B {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());

    // 데이터 입력
    Map<Integer, Integer> hm = new LinkedHashMap<>(); // 값, 등장횟수 저장 & 등장순서를 위해 linkedhashmap 사용
    st = new StringTokenizer(br.readLine(), " ");
    while (st.hasMoreTokens()) {
      int num = Integer.parseInt(st.nextToken());
      int cnt = hm.getOrDefault(num, 0);
      hm.put(num, cnt + 1);
    }
    List<Integer> list = new ArrayList<>(hm.keySet()); // 키 값 리스트

    // 정렬 및 출력
    Comparator<Integer> nc = (i1, i2) -> hm.get(i2) - hm.get(i1);
    list.stream().sorted(nc).forEach(i -> {
      for (int j = 0; j < hm.get(i); j++)
        System.out.print(i + " ");
    });
  }
}