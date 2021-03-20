//배열로 리스트 구현하기 

#include <stdio.h>
#include <stdlib.h>

#define SIZE 100

typedef struct{
  int V[SIZE]; //배열 선언
  int n; //리스트 원소의 개수
}ArrayList; //구조체 별칭

void init(ArrayList* L){ //구조체 초기화 
  L->n = 0;
}

void traverse(ArrayList* L){ 
  for(int i=0; i<L->n; i++)
    printf("[%d] ", L->V[i]);
  printf("\n");
}

void add(ArrayList* L, int pos, int item){
  //예외처리 -> 메서드로 따로 선언해주는게 더 좋음 
  if(L->n == SIZE){
    printf("fullListException");
    exit(1);
  }
  if(pos<0 || pos>L->n){
    printf("invalidIndexException");
    exit(1);
  }
  for(int i = L->n-1; i>=pos; i--)
    L->V[i+1] = L->V[i]; //값 위치 이동 
  L->V[pos] = item;
  L->n++;
}

int removeItem(ArrayList* L, int pos){
  int item = L->V[pos]; //remove될 값
  for(int i = pos+1; i<=L->n-1; i++)
    L->V[i-1] = L->V[i];
  L->n--;
  return item;

}

void main(){
  ArrayList list; //구조체 변수 선언 

  init(&list);

  add(&list, 0, 10); traverse(&list);
  add(&list, 1, 20); traverse(&list);
  add(&list, 2, 30); traverse(&list);
  add(&list, 3, 40); traverse(&list);

  getchar();
  removeItem(&list, 0); traverse(&list);
}