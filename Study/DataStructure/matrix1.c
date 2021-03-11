//문제) 행렬 지그재그로 채우기
//nxn 배열의 [0,0]에서 출발하여 1~n사이의 정수를 지그재그 순서로 채우는 알고리즘을 작성하라
//생각) 행을 기준으로 전체 반복문 -> 행이 짝수인지 홀수인지에 따라 열의 값 다르게 설정하기
//짝수 : 0->4, 홀수 : 4->0
#include <stdio.h>
#include <stdlib.h>

#define SIZE 5

void zigzag(int A[][SIZE]){
  int value = 1;
  int i, j;
  for(i = 0; i<SIZE; i++){
    if(i%2 == 0) //행이 짝수일 때
      for(j = 0; j<SIZE; j++){//오름차순
        A[i][j] = value;
        value++;
      }
    else //행이 홀수일 때 
      for(j = SIZE-1; j>=0; j--){//내림차순
        A[i][j] = value;
        value++;
      }
  }
}

void printArray(int A[][SIZE]){
  for(int i = 0; i<SIZE; i++){
    for(int j = 0; j<SIZE; j++)
      printf("%2d ", A[i][j]);
    printf("\n");
  }
}

void main(){
  int A[SIZE][SIZE] = {0};
  zigzag(A);
  printArray(A);
}
