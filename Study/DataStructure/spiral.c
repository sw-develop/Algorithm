//한 번의 턴을 생각하기

#include <stdio.h>
#include <stdlib.h>

int row, col;

void spiral(int arr[][col], int r, int c)
{
  int left = 0, right = c-1, top = 0, bottom = r-1;
  int i = 0, j = 0;
  int val = 1; //원소 값

  //생각) 배열에서의 이동방향 생각하기
  while(left <= right && top <= bottom) //기본조건
  {
    //오른쪽으로 
    for(i = left; i<=right; i++)
      arr[top][i] = val++;
    top++;
    //밑으로
    if(top <= bottom)
    { //top의 값이 변경되었으므로 조건 검사 해주기 
      for(i = top; i <= bottom; i++)
        arr[i][right] = val++;
      right--;
    }
    //왼쪽으로
    if(left <= right) //right의 값이 변경되었으므로 조건 검사
    {
      for(i = right; i>=left; i--)
        arr[bottom][i] = val++;
      bottom--;
    }
    //위로
    if(top <= bottom) //bottom의 값이 변경되었으므로 조건 검사
    {
      for(i = bottom; i>= top; i--)
        arr[i][left] = val++;
      left++;
    }
  }
  
}

void printArray(int arr[][col])
{
  for(int i = 0; i<row; i++)
  {
    for(int j = 0; j<col; j++)
      printf("%2d ", arr[i][j]);
    printf("\n");
  }
}

void main()
{
  printf("Input row & col :");
  scanf("%d %d", &row, &col);

  int arr[row][col];

  spiral(arr, row, col);

  printArray(arr);
}