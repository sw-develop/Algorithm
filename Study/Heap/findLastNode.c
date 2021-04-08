//주어진 배열 -> min heap 생성 -> binaryExpansion -> findLastNode
#include <stdio.h>
#include <stdlib.h>
#define MAX_ELMENT 200 //힙 최대 크기
#define MAX_STACK_SIZE 100 //스택 최대 크기

//--Stack--
typedef struct StackType{
  int data[MAX_STACK_SIZE]; //스택 배열로 구현
  int top;
}StackType;

void init_stack(StackType* s){ //스택 초기화 함수
  s->top = -1; 
}

int is_full(StackType* s){ 
  return (s->top == MAX_STACK_SIZE-1);
}

int is_empty(StackType* s){
  return (s->top == -1);
}

int pop(StackType* s){
  if(is_empty(s)){
    fprintf(stderr, "Stack is empty");
    exit(1);
  }
  else return s->data[(s->top)--]; //top이 가리키는 원소값 반환 후 top 위치 조정
}

void push(StackType* s, int item){
  if(is_full(s)){
    fprintf(stderr, "Stack is full"); 
    return;   
  }
  else s->data[++(s->top)] = item; //top 1 증가 후 해당 위치에 원소값 저장
}

//--Heap--
typedef struct{
  int key;
}element; //heap의 노드 구조체 정의 

typedef struct{
  element heap[MAX_ELMENT]; //배열로 heap 구현
  int heap_size;
}HeapType;

//Heap 초기 생성함수
HeapType* create(){
  return (HeapType*)malloc(sizeof(HeapType)); //동적할당
}
//Heap 초기화 함수
void init(HeapType* h){
  h->heap_size = 0;
}

//min_heap 함수(index 1부터 삽입됨)
void insert_min_heap(HeapType* h, element item){
  int i; //삽입된 노드의 위치
  i = ++(h->heap_size);

  //heap 이진 트리를 거슬러 올라가며 부모 노드와 비교하는 과정
  while((i != 1) && (item.key < h->heap[i/2].key)){
    h->heap[i].key = h->heap[i/2].key; //부모 노드와 자식 노드 위치 바꾸기 
    i /= 2; //바뀐 위치로 업그레이드 
  }
  h->heap[i] = item;
}

void printHeap(HeapType* h){
  printf("Heap: ");
  for(int i = 1; i<=h->heap_size; i++)
    printf("%d ", h->heap[i].key);
  printf("\n");
}

void binaryExpansion(int i, StackType* s){ 
  while(i>=2){
    push(s, i%2);
    i = i/2;
  }
  push(s, i);
}

int findLastNode(HeapType* h, int n){ //n : heap_size
  StackType s; //구조체 변수 s 선언
  init_stack(&s); //구조체 초기화

  binaryExpansion(n, &s);
  pop(&s); //remove highest-order bit

  int root = 1; 
  while(!is_empty(&s)){
    int bit = pop(&s);
    if(bit == 0) root = root*2;
    else root = root*2+1;
  }
  return h->heap[root].key;
}

int main(void){
  HeapType* h;
  h = create();
  init(h);

  element num;
  int intArr[10] = {2,6,4,14,7,12,8,17,15,9};
  for(int i = 0; i<sizeof(intArr)/sizeof(int); i++){
    num.key = intArr[i];
    insert_min_heap(h, num);
  }
  printHeap(h);

  printf("Last Node : %d", findLastNode(h, h->heap_size));

}


