//주제 : 극장예약시스템
//사용 자료구조 : 2차원 정수 배열

//구성
//기능 1.show_welcome 2.예약 3.취소 4.좌석보이기 

import java.util.Scanner;

public class ArrayEx8 {
  static Scanner kbd = new Scanner(System.in); // static 멤버 변수
  static int count_reservation = 0; //static 멤버변수, 예약 개수 

  public static void reservation(int[][] arr) { // 좌석 예약 메서드
    int row = 0, col = 0, col_length = 0;

    while (true) {
      System.out.println("== 좌석을 예약합니다 ==");
      System.out.printf("행 입력(1~%d) : ", arr.length);
      row = kbd.nextInt() - 1;

      col_length = arr[row].length;
      System.out.printf("열 입력(1~%d) : ", col_length);
      col = kbd.nextInt() - 1; // 비정방형 배열의 경우 해당 열의 길이 저장 변수

      if (arr[row][col] != 0) {
        System.out.println("(경고) 이미 예약된 좌석입니다.");
      } else {
        arr[row][col] = 1;
        count_reservation++;
        System.out.println("(알림) 예약이 완료되었습니다!");
        break;
      }
    }
  }

  public static void cancel(int[][] arr) { // 좌석 취소 메서드
    int row = 0, col = 0, col_length = 0;

    while (true) {
      System.out.println("== 취소할 좌석을 선택하세요 ==");
      showSeat(arr);
      System.out.printf("행 입력(1~%d) : ", arr.length);
      row = kbd.nextInt() - 1;

      col_length = arr[row].length;
      System.out.printf("열 입력(1~%d) : ", col_length);
      col = kbd.nextInt() - 1; // 비정방형 배열의 경우 해당 열의 길이 저장 변수

      if (arr[row][col] != 1) {
        System.out.println("(경고) 예약되지 않은 자리입니다.");
      } else {
        arr[row][col] = 0;
        count_reservation--;
        System.out.println("(알림) 취소가 완료되었습니다!");
        break;
      }
    }
  }

  public static void showSeat(int[][] arr) { // 현재 좌석 보는 메서드
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        if (arr[i][j] == 0)
          System.out.print("◽️ ");
        else
          System.out.print("▪️ ");
      }
      System.out.println();
    }
  }

  public static void showMenu() {
    System.out.println("###########################################");
    System.out.println("1.예약\t2.취소\t3.좌석보기\t4.나가기");
    System.out.println("###########################################");
    System.out.println("현재 고객님의 예약 좌석 개수 : " + count_reservation);
  }

  public static void welcome() {
    System.out.println("****************************************");
    System.out.println("\tWelcome to Ewha Movie\t");
    System.out.println("****************************************");
  }

  public static void main(String[] args) {
    // 좌석1) 정방향
    int[][] seats = new int[4][]; // 2차원 배열 선언 및 생성
    int choice = 0;

    seats[0] = new int[5];
    seats[1] = new int[4];
    seats[2] = new int[3];
    seats[3] = new int[4];

    welcome();
    while (true) {
      showMenu();
      System.out.print("Input: ");
      choice = kbd.nextInt();
      if (choice == 1)
        reservation(seats);
      else if (choice == 2)
        cancel(seats);
      else if (choice == 3)
        showSeat(seats);
      else {
        System.out.println("시스템이 종료됩니다.");
        break;
      }
    }
  }
}