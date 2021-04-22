//FIFO - 선입선출 특징
//배열을 이용한 원형큐 

#include <stdio.h>
#include <stdlib.h>
#define MAX_QUEUE_SIZE 5

typedef int element;
typedef struct{
  int front;
  int rear;
  element data[MAX_QUEUE_SIZE];
}QueueType;

void init_queue(QueueType* q) //큐 초기화
{
  q->front = 0;
  q->rear = 0;
}

int is_full(QueueType* q)
{
  return ((q->rear + 1) % MAX_QUEUE_SIZE == q->front); //배열의 index 범위 표현을 위해 배열의 크기로 나눈 나머지값 사용 
}

int is_empty(QueueType* q)
{
  return (q->front == q->rear); //front와 rear가 같으면 빈 큐  
}

void enqueue(QueueType* q, element item) //큐 원소 삽입 
{
  if(is_full(q)) fprintf(stderr, "full");
  q->rear = (q->rear + 1) % MAX_QUEUE_SIZE; //원소 삽입을 위한 rear 위치 조정 
  q->data[q->rear] = item; 
}

element dequeue(QueueType* q) //큐 원소 삭제 
{
  if(is_empty(q)) fprintf(stderr, "empty");
  q->front = (q->front + 1) % MAX_QUEUE_SIZE; //삭제될 원소의 index로 front 위치 조정 
  return q->data[q->front]; 
}

void print_queue(QueueType* q) //큐 출력 
{
  printf("Queue(front: %d, rear: %d) = ", q->front, q->rear);
  if(!is_empty(q))
  {
    int i = q->front;
    do{
      i = (i+1) % MAX_QUEUE_SIZE; //front의 다음 Index 부터 
      printf("%3d | ", q->data[i]);
      if(i == q->rear) {
        printf("break했지롱\n"); 
        break;
      } 
    }while(i != q->front);
  }
  printf("\n");
}

int main(void)
{
  QueueType q;
  init_queue(&q);
  int element;

  printf("<데이터 추가>\n");
  while(!is_full(&q)) {
    printf("정수 입력 :");
    scanf("%d", &element);
    enqueue(&q, element);
    print_queue(&q);
  }

  printf("Queue is full !!\n");
  printf("<데이터 가져오기>\n");
  while(!is_empty(&q)){
    printf("%3d\n", dequeue(&q));
    print_queue(&q);
  }
  printf("Queue is empty\n");
  return 0;
}