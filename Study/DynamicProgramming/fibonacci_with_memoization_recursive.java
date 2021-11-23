import java.util.*;

public class fibonacci_with_memoization_recursive {

  // 한 번 계산된 결과를 메모이제이션(Memoization)하기 위한 배열 초기화 
  public static long[] result = new long[1000000];

  // 피보나치 함수를 재귀함수로 구현 (with 탑다운 다이나믹 프로그래밍)
  public static long fibo(int x){
    if(x == 1 || x == 2){ // 재귀 종료 조건
      return 1;
    }

    if(result[x] != 0){ // 이미 계산한 적이 있는 값이라면 배열의 값 그대로 반환 
      return result[x];
    }

    result[x] = fibo(x-1) + fibo(x-2);  // 계산한 적이 없는 겂이라면 점화식에 따라 피보나치 결과 반환 
    return result[x];
  }

  public static void main(String[] args){
    long beforeTime = System.currentTimeMillis();
    
    System.out.println(fibo(100));

    long afterTime = System.currentTimeMillis();
    long secDiffTime = (afterTime - beforeTime);
    System.out.println("BeforeTime: " + beforeTime);
    System.out.println("AfterTime: " + afterTime);
    System.out.println("시간차이(m): " + secDiffTime);
  }

}