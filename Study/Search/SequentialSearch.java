import java.util.*;

public class SequentialSearch {
  
  public static int sequentialSearch(int count, String target, String[] arr){
    for(int i = 0; i < count; i++){
      System.out.println("arr[" + i + "] : " + arr[i]);

      //찾고자 하는 문자열과 동일한 경우 
      if(arr[i].equals(target)){
        return i+1; //찾은 원소의 인덱스+1 반환 
      }
    }
    return -1; //원소를 찾지 못한 경우 -1 반환 
  }

  public static void main(String[] args){
    Scanner kbd = new Scanner(System.in);

    System.out.println("생성할 원소 개수를 입력한 뒤 한 칸 띄고 찾고싶은 문자열을 입력하세요.");

    int count = kbd.nextInt(); // 원소 개수
    String target = kbd.next(); //찾고자 하는 문자열

    System.out.println("앞서 적은 원소 개수만큼 문자열을 입력하세요. 구분은 띄어쓰기 한 칸 입니다.");
    String[] arr = new String[count];
    for(int i = 0; i < count; i++){
      arr[i] = kbd.next();
    }

    //순차 탐색 수행 결과 출력
    System.out.println(sequentialSearch(count, target, arr));
  }
}