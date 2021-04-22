//연결리스트를 이용해 큐 구현
/*
배열로 구현했을 때와 달리 front변수가 리스트의 첫 노드를 가리킴 
*/


#include <stdio.h>
#include <stdlib.h>
#define MAX_QUEUE_SIZE 5

typedef int element;
typedef struct QueueNode{
  element data;
  struct QueueNode* link;
}QueueNode;

typedef struct{
  QueueNode* front, * rear; 
}QueueType;


void init_queue(LinkedQueueType* q)
{
  q->front = NULL; //첫 노드를 가리킴 
  q->rear = NULL; //끝 노드를 가리킴
}

int is_full(LinkedQueueType* q) //연결리스트이므로 최대 크기 없음 
{
  return 0;
}

int is_empty(LinkedQueueType* q)
{
  return (q->front = NULL); //front가 원래는 리스트의 첫 노드를 가리켜야함 
}

void enqueue(LinkedQueueType* q, element item)
{
  QueueNode* newNode = (QueueNode*)malloc(sizeof(QueueNode)); //새로운 노드 동적할당
  newNode->data = item;
  newNode->link = NULL; //연결리스트의 마지막에 삽입되므로 
  if(is_empty(q)) //첫 노드일 때 
  {
    q->front = newNode;
    q->rear = newNode;
  }
  else //기존에 노드가 존재할 때
  {
    q->rear->link = newNode; //기존의 마지막 노드가 새로 생성된 노드를 가리키도록 
    q->rear = newNode; //rear가 가리키는 노드 설정 
  }
}

element dequeue(LinkedQueueType* q)
{
  if(is_empty(q))
  {
    fprintf("Queue is empty!");
    exit(1);
  }
  element data;
  QueueNode* temp = q->front;
  data = temp->data;
  q->front = temp->link;
  if(q->front == NULL) q->rear = NULL; //주의) 마지막 노드였다면, 큐를 공백으로 만들어줘야함(rear변수가 가리키던 노드는 삭제되니까)
  free(temp);
  return data;
}

void printQueue(LinkedQueueType* q)
{
  for(QueueNode* p = q->front; p != NULL; p = p->link)
    printf("%d -> ", p->data);
  printf("NULL\n");
}

int main(void)
{
  int item = 0;
  LinkedQueueType q;
  init_queue(&q);

  printf("<Insert Data>\n");
  enqueue(&q, 1); print_queue(&q);
  enqueue(&q, 1); print_queue(&q);
  enqueue(&q, 1); print_queue(&q);

  printf("<Delete Data>\n");
  dequeue(&q);  print_queue(&q);
  dequeue(&q);  print_queue(&q);
  dequeue(&q);  print_queue(&q);
  dequeue(&q);  print_queue(&q);
  return 0; 
}