#include <stdio.h>

int mostOnes(int A[][6], int r, int c){
  int i = 0, j = 0, row = 0;
  while((i<r) && (j<c)){
    if(A[i][j] == 0) i += 1;
    else{
      row = i;
      j += 1;
    }
  }
  return row;
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
