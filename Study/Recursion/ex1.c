#include <stdio.h>
#include <stdlib.h>

void rPrintDigits(int n){
  if(n<10) printf("%d\n", n); //재귀 끝낼 조건
  else{
    rPrintDigits(n/10);
    printf("%d\n", n%10);
  }
}

void printDigits(){
  int n;
  printf("enter a number : ");
  scanf("%d", &n);
  if(n<0) printf("negative!");
  else rPrintDigits(n); //간접재귀
}

void main(){
  printDigits();
}