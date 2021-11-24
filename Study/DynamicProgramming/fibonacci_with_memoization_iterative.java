import java.util.*;

public class fibonacci_with_memoization_iterative {

  public static long[] result = new long[1000000];

  public static void main(String[] args){
    long beforeTime = System.currentTimeMillis();

    // 첫 번째와 두 번째 값은 1로 고정 
    result[1] = 1;
    result[2] = 1;

    int val = 100; // 찾고자 하는 값

    // 피보나치 함수를 반복문으로 구현(다이나믹 프로그래밍 보텀업 방식)
    for(int i = 3; i <= val; i++){
      result[i] = result[i-1] + result[i-2];
    }

    System.out.println(result[val]);

    long afterTime = System.currentTimeMillis();
    long secDiffTime = (afterTime - beforeTime);
    System.out.println("BeforeTime: " + beforeTime);
    System.out.println("AfterTime: " + afterTime);
    System.out.println("시간차이(m): " + secDiffTime);
  }
}