//BOJ 2910

import java.util.*;
import java.io.*;

class Data implements Comparable<Data> {
  int n; //숫자
  int cnt; //등장횟수

  public Data(int n, int cnt) {
    this.n = n;
    this.cnt = cnt;
  }

  @Override
  public int compareTo(Data o) {
    return o.cnt - this.cnt; //등장횟수 내림차순
  }
}

public class Main3A {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());

    // 데이터 입력 및 정렬
    List<Data> input = new LinkedList<>();
    st = new StringTokenizer(br.readLine(), " ");
    while (st.hasMoreTokens()) {
      int num = Integer.parseInt(st.nextToken());
      Data exist = null;
      for (Data d : input) {
        if (d.n == num) {
          exist = d;
          break;
        }
      }
      if (exist == null) input.add(new Data(num, 1));
      else exist.cnt += 1;
    }
    Collections.sort(input); //O(nlogn)

    // 출력
    for (Data d : input) {
      while (d.cnt-- > 0)
        System.out.print(d.n + " ");
    }
  }
}

/* 문제 회고

정렬 조건
- 등장 횟수 내림차순
- 등장 횟수 같다면, 먼저 나온 것이 앞

객체 배열 메모리 초과 => 어떻게 개선할까?
모든 숫자를 위한 공간을 생성하지 말고, 입력으로 받은 숫자에 대한 공간만 생성하기

*/