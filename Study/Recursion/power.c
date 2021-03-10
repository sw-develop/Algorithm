#include <stdio.h>
#include <stdlib.h>
//사용 원리)
//x^n = (x^2)^(n/2)로 표현 가능
//n이 짝수 : x^2을 먼저 계산 -> n/2 제곱
//n이 홀수 : x^2을 먼저 계산 -> (n-1)/2 제곱 -> x를 곱하기 
//power(x,n) 
//  power(x^2, n/2)
//  x * power(x^2, n-1/2)

int iter_power(int x, int n){
  int result = 1;

  for(int i = 0; i<n; i++)
    result *= x;
  return result;
}

int recur_power(int x, int n){
  if(n==0) return 1; //재귀 끝낼 조건
  else if(n%2 == 0) //n이 짝수일 때
    return recur_power(x*x, n/2);
  else //n이 홀수일 때
    return x * recur_power(x*x, (n-1)/2);
}

void main(){
  printf("%d", recur_power(2,10));
}

