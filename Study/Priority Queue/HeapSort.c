#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define MAX_ELEMENT 20

typedef struct{
  int heap[MAX_ELEMENT];
  int heap_size;
}HeapType;

void init(HeapType* h){
  h->heap_size = 0;
}

/*Insert*/
void upHeap(HeapType* h){
  int i = h->heap_size; //삽입된 원소의 위치 
  int key = h->heap[i];

  while((i != 1) && (key < h->heap[i/2])){ //최소힙 조건 
    h->heap[i] = h->heap[i/2];
    i /= 2;
  }
  h->heap[i] = key;
}

void insertItem(HeapType* h, int key){
  h->heap_size++;
  h->heap[h->heap_size] = key; //이진트리의 마지막 위치에 저장
  upHeap(h);
}

/*Delete*/
void downHeap(HeapType* h){
  int temp = h->heap[1];
  int parent = 1, child = 2;

  while(child <= h->heap_size){
    //현재 노드의 자식 노드 중 더 큰 자식 노드 찾기 
    if((child < h->heap_size) && (h->heap[child] > h->heap[child+1])) child++; //오른쪽 자식 노드의 값이 더 크다면 
    if(temp <= h->heap[child]) break; //최대 힙 성질 만족
    else{ //최대힙 성질 만족 X -> 자식노드와 값 바꾸기
      h->heap[parent] = h->heap[child];
      //값 갱신하기 
      parent = child;
      child *= 2;
    }
  }
  h->heap[parent] = temp;
}

int removeMin(HeapType* h){
  int key = h->heap[1];
  h->heap[1] = h->heap[h->heap_size];
  h->heap_size--;
  downHeap(h);
  return key;
}

/*HeapSort*/
void HeapSort(HeapType* h, int list[]){
  HeapType heap; //empty heap
  init(&heap);

  for(int i = 1; i<=h->heap_size; i++){
    heap.heap[i] = h->heap[i]; //새로 생성된 힙에 값 복사하기
    heap.heap_size++; 
  }

  for(int i = 1; i<-h->heap_size; i++)
    list[i] = removeMin(&heap);
}

/*제자리 힙 정렬 - 배열 1개만 사용하기*/
void inPlaceHeapSort(HeapType* h){
  int size = h->heap_size; //원래의 힙 크기 저장 
  int key;
  for(int i = 0; i < size; i++)
  {
    key = removeMin(h); 
    h->heap[h->heap_size+1] = key; //힙을 구현한 배열의 가장 오른쪽부터 차례대로 오름차순 정렬되어 값 저장됨 
  }
}

/*PrintArray*/
void printArray(int list[], int n){
  for(int i = 1; i <= n; i++)
    printf("[%d] ", list[i]);
  printf("\n");
}

/*Print*/
void printHeap(HeapType* h){
  for(int i=1; i <= h->heap_size; i++){
    printf("[%d] ", h->heap[i]);
  }
  printf("\n");
}

void main(){
  HeapType h;
  init(&h);
  int list[MAX_ELEMENT] = {0};
  srand(time(NULL));

  for(int i = 0; i < 15; i++)
    insertItem(&h, rand()%100 + 1);
  printHeap(&h);
  
  printf("\n");

  //제자리 정렬 
  inPlaceHeapSort(&h);
  for(int i =1; i<=15; i++) //힙의 크기까지
    printf("[%d] ", h.heap[i]);

  printf("\n");
  for(int i = 0; i<MAX_ELEMENT; i++)
    printf("[%d] ", h.heap[i]);

}