public class fibonacci_recursion {
  public static void main(String[] args) {
    long startTime = System.nanoTime();

    int result = fibo(40);
    
    long endTime = System.nanoTime();

    System.out.println(result);

    long secDiffTime = (endTime - startTime);
    System.out.println("수행시간(ns): " + secDiffTime);
	}

	public static int fibo(int n) {
		if (n <= 1)
			return n;
		else 
      return fibo(n-2) + fibo(n-1);
	}
}


// n = 40 
// 102334155
// 수행시간(ns): 1319571553