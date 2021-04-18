//선택정렬
//원리 : 가장 작은 값부터 찾아서 차례대로 정렬
//시간복잡도 : 이중for문 -> O(n^2) 
/*코드*/
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define MAX_SIZE 10
#define SWAP(x,y,t) ((t)=(x), (x)=(y), (y)=(t)) //값 교환을 위한 매크로 정의

void selection_sort(int list[], int n){
  int i, j, least, temp;
  for(int i = 0; i < n-1; i++) //1~n-2 (마지막 원소는 자동정렬 되니까)
  {
    least = i; 
    for(j=i+1; j<n; j++) //최소값 위치 찾기 
      if(list[least] > list[j])
        least = j; 
    SWAP(list[least], list[i], temp); 
  }
}

int main(void){
  int list[MAX_SIZE]; //정렬 대상 배열 
  int i, n;
  n = MAX_SIZE;
  srand(time(NULL));

  for(i=0; i<n; i++)
    list[i] = rand()%100+1; //난수 발생 범위 1~100

  printf("\nBefore Sorting\n");
  for (i = 0; i < n; i++)
		printf("%d ", list[i]);
  
  selection_sort(list, n); //선택 정렬 호출

  printf("\nAfter Selection Sorting\n");
	for (i = 0; i < n;i++)
		printf("%d ", list[i]);
	printf("\n");
	return 0;
}