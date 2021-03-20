//연결리스트로 리스트 구현하기
//remove, removeFirst, removeLast 추가 구현하기
#include <stdio.h>
#include <stdlib.h>

typedef struct ListNode{
  int data; //원소 
  struct ListNode* link; //링크, 구조체 포인터 변수
}ListNode;

typedef struct{
  ListNode* head; //헤드 포인터 
}LinkedListType;

void init(LinkedListType* L){
  L->head = NULL; //헤드 포인터 초기화 
}

void addFirst(LinkedListType* L, int item){
  ListNode* node = (ListNode*)malloc(sizeof(ListNode)); 
  node->data = item;
  node->link = L->head;
  L->head = node;
}

void addLast(LinkedListType* L, int item){
  ListNode* p;
  ListNode* node = (ListNode*)malloc(sizeof(ListNode));
  node->data = item;
  node->link = NULL;

  for(p = L->head; p->link != NULL; p = p->link){}
  p->link = node;
}

void addNode(LinkedListType* L, int pos, int item){
  ListNode* node = (ListNode*)malloc(sizeof(ListNode));
  ListNode* before = L->head;
  for(int i = 0; i<pos-1; i++)
    before = before->link;
  node->data = item;
  node->link = before->link;
  before->link = node;
}

int removeNode(LinkedListType* L, int pos){
  ListNode* deleted; //삭제될 노드 저장 가리킬 포인터 변수
  int item; //삭제될 노드의 원소 
  ListNode* before = L->head;
  for(int i = 0; i<pos-1; i++)
    before = before->link;
  deleted = before->link;
  item = deleted->data;
  before->link = deleted->link;
  free(deleted); //동적할당 해제 
  return item;
}

int removeFirst(LinkedListType* L){
  ListNode* deleted;
  int item;

  deleted = L->head;
  item = deleted->data;
  L->head = deleted->link;
  free(deleted);
  return item;
}

int removeLast(LinkedListType* L){
  ListNode* deleted;
  int item;
  ListNode* before;

  //마지막 노드의 전 노드의 Link를 null로 연결안해줘도 되나??
  for(before = L->head; before->link != NULL; before = before->link){
    if(before->link->link == NULL) {
      deleted = before->link;
      item = deleted->data;
      break;
    }
  }
  before->link = NULL;
  free(deleted);

  return item;
}


void printList(LinkedListType* L){
  for(ListNode* p = L->head; p != NULL; p=p->link)
    printf("[%d] -> ", p->data);
  printf("NULL\n");
}


void main(){
  LinkedListType list;

  init(&list);

  addFirst(&list, 10); printList(&list);
  addFirst(&list, 20); printList(&list);
  addLast(&list, 30); printList(&list);
  addNode(&list, 1, 40); printList(&list);

  getchar();
  removeFirst(&list); printList(&list);
  removeLast(&list); printList(&list);
  removeNode(&list, 1); printList(&list);
}