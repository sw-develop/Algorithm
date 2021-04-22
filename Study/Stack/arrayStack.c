//기본배열이용한 스택 

#include <stdio.h>
#include <stdlib.h>

#define MAX_STACK_SIZE 100 //stack의 최대 크기

typedef int element;
element stack[MAX_STACK_SIZE];
int top = -1; //스택의 저장 위치 상황 표시 변수 

int is_full(void)
{
  return (top == MAX_STACK_SIZE-1);
}

int is_empty(void)
{
  return (top == -1);
}

element pop(void)
{
  if(is_empty())
  {
    fprintf(stderr,"Empty!");
    exit(1);
  }
  else return stack[top--]; //top이 가리키던 원소 값 반환 후 top 위치 조정
}

element peek(void)
{
  if(is_empty())
  {
    fprintf(stderr,"Empty!");
    exit(1);
  }
  else return stack[top]; 
}

void push(element item)
{
  if(is_full())
  {
    fprintf(stderr, "Full!");
    exit(1);
  }
  else stack[++top] = item;
}

int main(void)
{
  push(1);
  push(2);
  push(7);
  printf("%d\n", pop());
  printf("%d\n", pop());
  printf("%d\n", pop());
  printf("%d\n", pop()); //빈 스택인 상황
  return 0;
}
