//행렬에서 1이 가장 많은 행을 찾기 
//BUT 처음에 1이 아니면 해당 열은 패스한다 

#include <stdio.h>

int mostOnes(int A[][6], int r, int c){
  int i = 0, j = 0;
  while(1){
    while(A[i][j] == 1){
      j += 1; //열 이동 
      if(j==c) return i;
    }
    int row = i;
    while(A[i][j] == 0){
      i += 1; //행 이동 
      if(i==r) return row;
    }
  }  
}

void main(){
  int A[4][6] = {
    {1,1,1,1,0,0},
    {1,1,1,0,0,0},
    {1,1,1,1,1,1},
    {1,1,1,1,1,0}
  };
  
  printf("%d", mostOnes(A, 4, 6));

  

}
