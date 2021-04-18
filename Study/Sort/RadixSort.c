//기수정렬

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define MAX_SIZE 15
#define BUCKETS 10
#define DIGITS 2

/*Queue -> 원형큐로 구현*/ 
typedef int element;
typedef struct{
  element data[MAX_SIZE]; //배열로 구현 
  int front, rear; 
}QueueType;

void init_queue(QueueType* q){
  q->front = q->rear = 0;
}

int is_empty(QueueType* q){
  return q->front == q->rear;
}

int is_full(QueueType* q){
  return q->front == (q->rear + 1) % MAX_SIZE;
}

void enqueue(QueueType* q, element item){
  if(is_full(q)) exit(1);

  q->rear = (q->rear + 1) % MAX_SIZE; //새로운 값 저장할 index 위치 조정 
  q->data[q->rear] = item;
}

element dequeue(QueueType* q){
  if(is_empty(q)) exit(1);

  q->front = (q->front+1) % MAX_SIZE; //front 위치 조정
  return q->data[q->front];
}

void radix_sort(int list[], int n){
  int i, b, d, factor = 1;
  QueueType queues[BUCKETS]; //Bucket의 개수만큼 큐 필요

  for(b=0; b<BUCKETS; b++) init_queue(&queues[b]); //큐 초기화

  for(d=0; d<DIGITS; d++) //총 자릿수 만큼 반복(낮은 자리 수부터)
  {
    //1. 원소들을 자리수에 따라 큐에 입력
    for(i=0; i<n; i++)
      enqueue(&queues[(list[i]/factor)%10], list[i]);
    //2. 버킷에서 하나씩 꺼내어 list 재구성 
    for(b=i=0; b<BUCKETS; b++)
      while(!is_empty(&queues[b]))
        list[i++] = dequeue(&queues[b]);
    //3. 분류할 자릿수 증가시키기  
    factor *= 10;
  }
}

void main(){
  int list[MAX_SIZE];
  srand(time(NULL));

  for(int i = 0; i<MAX_SIZE; i++)
    list[i] = rand() % 100 + 1;
  
  for(int i = 0; i<MAX_SIZE; i++)
    printf("[%d] ", list[i]);

  printf("\n기수정렬후\n");
  radix_sort(list, MAX_SIZE);

  for(int i = 0; i<MAX_SIZE; i++)
    printf("[%d] ", list[i]);

}
