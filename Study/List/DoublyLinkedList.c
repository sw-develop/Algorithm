//이중원형연결리스트 
#include <stdio.h>
#include <stdlib.h>

//이중연결을 위한 노드구조
typedef int element;
typedef struct dListNode{
  element data; //저장할 데이터
  struct dListNode* llink; //left link
  struct dListNode* rlink; //right link
}dListNode;

//이중연결리스트 초기화
void init(dListNode* phead)
{
  phead->llink = phead;
  phead->rlink = phead;
}

//새로운 데이터 삽입 - 새로운 데이터를 기존노드 pnode의 오른쪽에 삽입 
void dinsert(dListNode* pnode, element val)
{
  dListNode* newNode = (dListNode*)malloc(sizeof(dListNode)); //새로운 노드 생성 
  newNode->data = val;
  newNode->rlink = pnode->rlink; //새로운 노드의 rlink는 기존노드의 rlink가 가리키는 값을 가짐
  pnode->rlink->llink = newNode; //기존노드의 rlink가 가리키는 노드의 llink가 새로운 노드를 가리킴 
  newNode->llink = pnode;
  pnode->rlink = newNode;
}


//기존 데이터 삭제 - 리스트의 맨 앞 원소 삭제 
void ddelete(dListNode* head, dListNode* removed)
{
  if(removed == head) return; //공백상태의 리스트
  removed->rlink->llink = head; //삭제될 원소의 그 다음 노드가 이제 리스트의 첫 번째 노드가 됨 
  head->rlink = removed->rlink; 
  free(removed); 
}

//이중연결리스트 출력
void print_dlist(dListNode* phead)
{
  dListNode* p = NULL; //포인터 p가 노드를 가리킴 
  for(p=phead->rlink; p != phead; p = p->rlink) //head 다음의 첫 번째 원소부터 마지막 원소까지
    printf("%3d ", p->data);
  printf("\n");
}

int main(void)
{
  dListNode* head = (dListNode*)malloc(sizeof(dListNode));

  init(head);
  printf("맨 앞에 노드 5개 순차적 추가\n");
  for(int i = 0; i < 5; i++)
  {
    dinsert(head, i+1);
    print_dlist(head);
  }

  printf("맨 앞 노드 순차적 삭제\n");
  print_dlist(head);
  for(int i = 1; i < 6; i++)
  {
    ddelete(head, head->rlink);
    print_dlist(head);
  }
  free(head);
  return 0;
}