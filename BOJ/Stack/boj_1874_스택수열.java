//생각)
//스택 peek() 함수 사용해 원하는 변수가 맨 위에 없으면 탈락 
//수열의 다음 값 < 이전 값 : peek() 반환 값과 수열의 다음 값이 다르면 불가능
//수열의 다음 값 > 이전 값 : 계속 push하면 됨 

import java.util.Scanner;
import java.util.Stack;

public class boj_1874_스택수열{
  public static void main(String[] args){
    Scanner kbd = new Scanner(System.in);
    int[] array; //순열 저장 배열
    int[] stackCheck; //push, pop 저장 배열
    
    Stack<Integer> s = new Stack<Integer>(); //스택 인스턴스 생성

    int i=0;
    int p1=1; //추가되는 수 진행 표시 
    int p2=1; //array 진행 표시
    int p3=0; //stackCheck 진행 표시
    int val; //pop된 값 저장
    boolean check = true; //순열 가능한지 체크
    
    //Input
    int size = kbd.nextInt();
    array = new int[size];
    stackCheck = new int[size*2];
    for(i = 0 ; i<size; i++)
      array[i] = kbd.nextInt();

    //판별
    //1.첫 번째 수 처리
    for(i = 0; i<array[0]; i++){
      s.push(p1);
      stackCheck[p3++] = 1;
      p1++;
    }
    val = s.pop();
    stackCheck[p3++] = 0;

    //2.나머지 처리 
    while(p2<size){
      if(array[p2] < val){//수열 다음 값 < val
        if(s.peek() != array[p2]) {
          check = false;
          //break;
        }
        else
          val = s.pop();
          stackCheck[p3++] = 0;
      }
      else{//수열 다음 값 > val
        for(i=p1-1;i<array[p2];i++){//주의!
          s.push(p1);
          stackCheck[p3++] = 1;
          p1++;
        }
        val = s.pop();
        stackCheck[p3++] = 0;
      }

      //System.out.println(array[p2] + " " + check);

      if(check==false) break;
      p2++;
    }

    //System.out.println(check);
    if(check == true){
      for(int k = 0; k < p3; k++){
      if(stackCheck[k] == 1) System.out.println('+');
      else System.out.println('-');
      }
    }
    else System.out.println("NO");
  }

}