//개선) 생각은 동일하지만 구현방식을 다르게 하기
//Scanner -> BufferedReader 사용
//stack은 배열로 표현
//StringBuilder 사용

import java.io.*;

class boj_1874_2{
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder(); //+ - 저장

    int size = Integer.parseInt(br.readLine());
    int stack[] = new int[size]; //스택 - 배열로 선언

    int idx = 0; //스택 배열 index
    int val = 0; //숫자 진행 저장

    while(size-- > 0){ //전체 반복 뼈대 : n번 반복
      int input = Integer.parseInt(br.readLine()); //순열을 이루는 수 입력
      if(input > val){
        for(int i = val+1; i<input; i++){
          stack[idx++] = i;
          sb.append("+\n"); 
        }
        sb.append("+\n");
        val = input; //진행 갱신
      }
      else { //input < val
        if(stack[--idx] != input){
          System.out.println("NO");
          return;
        } 
      }

      sb.append("-\n"); 
      //System.out.println("Stack : "  + stack[idx-1]);
    }

    System.out.println(sb);
  }
}

