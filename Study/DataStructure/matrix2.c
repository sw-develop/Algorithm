//문제) 행렬 나선형 채우기
//nxm 배열의 [0,0]에서 출발하여 1~nm사이의 정수를 나선형 순서로 채우는 알고리즘을 작성하라
//생각) 한번에 처리할 수 없을 때는 각각 나눠서 처리해주기(가로 세로 등등)
//필요한 변수들 미리 선언해두기
#include <stdio.h>
#include <stdlib.h>

#define col 5
#define row 5

void spiral(int A[][col], int n, int m){
  int left = 0, right = m-1; //col 
  int top = 0, bottom = n-1; //row
  int value = 1, j;
  while(left<=right && top<=bottom){
    for(j=left; j<=right; j++){
      A[top][j] = value;
      value++;
    }
    top++;
    if(top<=bottom){
      for(j=top; j<=bottom; j++){
        A[j][right] = value;
        value++;
      }
    }
    right--;
    if(left<=right){
      for(j=right; j>=left; j--){ //그냥 내림차순으로 하면 안되나?
        A[bottom][j] = value;
        value++;
      }
    }
    bottom--;
    if(top<=bottom){
      for(j=bottom; j>=top; j--){
        A[j][left] = value;
        value++;
      }
    }
    left++; //연산 주의!
  }
}

void printArray(int A[][col]){
  for(int i = 0; i<row; i++){ //행
    for(int j = 0; j<col; j++) //열
      printf("%2d ", A[i][j]);
    printf("\n");
  }
}

void main(){
  int A[row][col] = {0};

  spiral(A, row, col);
  printArray(A);
}
