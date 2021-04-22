//연결리스트로 스택 구현 
#include <stdio.h>
#include <stdlib.h>

typedef int element;

typedef struct StackNode{ //스택노드 구조체 
  element data; //data
  struct StackNode* link; //link
}StackNode;

typedef struct{
  StackNode* top; //스택 top 노드주소 
}LinkedStackType;

void init(LinkedStackType* s)
{
  s->top = NULL; //초기에는 빈 stack
}

int is_full(LinkedStackType* s) //연결리스트로 구현하므로, full은 될 수 없음! 
{
  return 0; 
}

int is_empty(LinkedStackType* s)
{
  return (s->top == NULL);
}


/*
  단순 연결리스트의 경우 이전 노드와 마지막 노드까지 가려면 복잡하니까,
  스택의 pop = 단순연결리스트의 맨 앞 원소 삭제,
  스택의 push = 단순연결리스트의 맨 앞 원소 삽입과 같은 것임!
*/

element pop(LinkedStackType* s)
{
  if(is_empty(s)) //빈 스택일 때
  {
    fprintf(stderr, "Stack is empty!");
    exit(1);
  }
  else
  {
    StackNode* temp = s->top; //구조체 포인터 temp가 삭제할 노드를 가리킴 
    element data = temp->data;
    s->top = temp->link;
    free(temp); //삭제된 노드에게 할당된 메모리 반환
    return data; //삭제된 원소 값 반환 
  }
}

void push(LinkedStackType* s, element item)
{
  StackNode* newNode = (StackNode*)malloc(sizeof(StackNode)); //새로 추가할 노드 생성 
  newNode->data = item;
  newNode->link = s->top;
  s->top = newNode;
}

void print_stack(LinkedStackType* s)
{
  for(StackNode* p = s->top; p != NULL; p = p->link) //첫 번째 원소 ~ 마지막 원소
    printf("%d -> ", p->data);
  printf("NULL\n");
}

int main(void)
{
  LinkedStackType s;
  init(&s); //call by reference
  push(&s, 1);  print_stack(&s);
  push(&s, 2);  print_stack(&s);
  push(&s, 3);  print_stack(&s);
  pop(&s);  print_stack(&s);
  pop(&s);  print_stack(&s);
  pop(&s);  print_stack(&s);
  pop(&s);  print_stack(&s);
  return 0;
}