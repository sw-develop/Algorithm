//2017년 a월 b일의 요일은? - a와 b 입력 받아 요일 찾기
//2017년 1월 1일 - 일요일
//1-7 : 일 - 토
//8-14 : 일 - 토
//2017년 a월 b일의 (전체 일수 % 7 - 1)이 해당 날짜의 요일임

import java.util.*;

public class Main5A {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        int a = kbd.nextInt();
        int b = kbd.nextInt();
        kbd.close();

        //2017년 1월 1일 == 일요일
        String[] dayOfWeek = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        //월별 일 수
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int day = 0;
        for (int i = 0; i < a-1; i++) {
            day += daysInMonth[i];
        }
        day += b;

        System.out.println(dayOfWeek[day % 7 - 1]);
    }
}