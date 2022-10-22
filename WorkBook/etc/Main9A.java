//일단 생각나는 방법으로 풀자! 그게 O(N^2)이 아닐 수 있다!!!
//숫자의 각 자리수의 값이 8인지 확인
//%와 / 사용
//String으로 변환 후 각 자리 접근

public class Main9A {

    public static void main(String[] args) {
        int sum = 0;
        for (int i = 8; i <= 1000; i++) {
            //각 자리수가 8인지 확인해서 카운트
            int n = i;
            while (n != 0) { // O(N) -> 이 코드 한 줄이 몇 번 수행되느냐
                if (n % 10 == 8) sum += 1;
                n = n / 10;
            }
        }
        System.out.println(sum);
    }
}