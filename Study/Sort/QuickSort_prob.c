//문제) 배열 L에서 모든 파랑 원소들이 빨강 원소들의 앞에 오도록 재배치하기 -> 퀵 정렬 partition함수에서 값 교환 방식 적용 

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define MAX_SIZE 5
#define SWAP(x,y,t) ((t)=(x), (x)=(y), (y)=(t)) 

void partition(char list[], int left, int right){
  int low = left-1, high = right + 1;
  char temp;

  do
  {
    do{
      low++;
    }while(list[low] == 'B');

    do{
      high--;
    }while(list[high] == 'R');

    if(low < high)
      SWAP(list[low], list[high], temp);

  }while(low < high);
  
}


void main(){
  char list[MAX_SIZE];
  srand(time(NULL));

  for(int i = 0; i < MAX_SIZE; i++)
  {
    if (rand() % 2 == 0)
      list[i] = 'B';
    else
      list[i] ='R';
  }

  for(int i = 0; i < MAX_SIZE; i++)
    printf("[%c] ", list[i]);
  printf("\n"); 

  partition(list, 0, MAX_SIZE-1); //배열의 처음, 마지막 index 전달

  for(int i = 0; i < MAX_SIZE; i++)
    printf("[%c] ", list[i]);
  printf("\n");
}

