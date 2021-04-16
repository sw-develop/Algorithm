//누적 평균 구하기

#include <stdio.h>

int arr1[5];
int arr2[5];

void prefixAverage1(int X[], int n){ //시간복잡도 : O(n^2)
//이중 for문 사용 
  for(int i = 0; i < n; i++){
    int sum = 0; //sum 초기화 
    for(int j = 0; j <= i; j++){
      sum += X[j]; //인덱스 주의!
    }
    printf("sum : %d\n", sum);
    arr1[i] = sum/(i+1);
  }
}

void prefixAverage2(int X[], int n){ //시간복잡도 : O(n)
  int sum = 0;
  for(int i = 0; i<n; i++){
    sum += X[i];
    arr2[i] = sum/(i+1);
  }
}

void main(){
  int X[5] = {1,2,3,4,5};
  int length = sizeof(X)/sizeof(int);

  prefixAverage1(X, length);
  prefixAverage2(X, length);
  
  printf("arr1\n");
  for(int i = 0; i < length; i++)
    printf("%d ", arr1[i]);

  printf("\narr2\n");
  for(int i = 0; i < length; i++)
    printf("%d ", arr2[i]);
}