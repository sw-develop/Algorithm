//내림차순 정렬하기
//Arrays.sort()에서 Collections.reverseOrder() 사용하려면 Integer처럼 Wrapper 클래스로 선언해야 함
//정렬 구현

import java.util.*;

public class Main2A {

    public static void main(String[] args) {
        int[] input = {21, 9, 4, 1, 5};

        selectionSort(input);

        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
    }

    public static void selectionSort(int[] arr) { //선택정렬 내림차순
        for (int i = 0; i < arr.length; i++) {
            int idx = i;
            int n = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > n) {
                    n = arr[j];
                    idx = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;
        }
    }
}