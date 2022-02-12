import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);

    int N = kbd.nextInt(); // 줄 개수
    int M = kbd.nextInt(); // 브랜드 개수

    LinkedList<Integer> pack = new LinkedList<>();
    LinkedList<Integer> one = new LinkedList<>();

    for(int i = 0; i < M; i++) {
      pack.add(kbd.nextInt());
      one.add(kbd.nextInt());
    }
    Collections.sort(pack);
    Collections.sort(one);

    int minPackVal = pack.get(0);
    int minOneVal = one.get(0);
    long result = 0;
      
    if(6*minOneVal < minPackVal) {
        result += N * minOneVal;
    }
    else {
        if(N % 6 == 0) {
        result += (N/6) * minPackVal;
        }
        else {
            result += (N/6) * minPackVal;

            int val1 = minPackVal; // 패키지 1개 더 구입
            int val2 = (N%6) * minOneVal; // 낱개로 구입
            result += Math.min(val1, val2);
        }
    }

    System.out.println(result);

  }
}