//상향식 힙 생성 방식 
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define MAX_ELEMENT 100

struct Heap
{
  int H[MAX_ELEMENT]; //힙 구현 배열  
  int n; //힙의 크기 
}_Heap;


/*비재귀적 상향식 힙 생성*/
void downHeap(int i)
{
  if(i*2 > _Heap.n) return; //자식노드가 없다는 의미 
  if(_Heap.H[i] < _Heap.H[i*2] || _Heap.H[i] < _Heap.H[i*2 + 1]) //최대힙을 만족하도록 자식노드와 값 비교하여 교환
  {
    if(_Heap.H[i*2] > _Heap.H[i*2+1]){ //값 교환 
      int temp;
      temp = _Heap.H[i];
      _Heap.H[i] = _Heap.H[i*2];
      _Heap.H[i*2] = temp;
      downHeap(i*2); //새로운 원소 위치를 전달하여 재귀 호출
    }
    else{
      int temp = _Heap.H[i];
      _Heap.H[i] = _Heap.H[i*2+1];
      _Heap.H[i*2+1] = temp;
      downHeap(i*2 + 1); //새로운 원소 위치 전달하여 재귀 호출 
    }
  }
  else{
    return;
  }
}

void buildHeap() //주어진 배열을 heap이라고 가정하고 heap의 부모노드인 부분들에 대해 downheap을 적용하여 최대 힙 구현(상향식) 
{
  for(int i = _Heap.n/2; i>=1; i--) //감소 주의! 
    downHeap(i); //부모 노드의 Index 전달 
}

/*제자리 정렬 - 오름차순*/
int removeMax()
{
  int key = _Heap.H[1]; //삭제될 루트 노드 값 
  _Heap.H[1] = _Heap.H[_Heap.n--]; //마지막 노드를 노트 노드로 올리기
  downHeap(1); //상향식 힙 생성 방식 적용 
  return key; 
}

void inPlaceHeapSort(){
  int size = _Heap.n;
  int key;
  for(int i = 0; i<size; i++)
  {
    key = removeMax(); 
    _Heap.H[_Heap.n + 1] = key; //힙을 구현한 배열의 마지막 index부터 왼쪽으로 정렬된 값 저장하여 오름차순 구현 
  }
}

void printHeap()
{
  for(int i = 1; i <= _Heap.n; i++)
    printf("[%d] ", _Heap.H[i]);
  printf("\n");
}

void printArray()
{
  for(int i = 1; _Heap.H[i] > 0; i++)
    printf("[%d] ", _Heap.H[i]);
  printf("\n");
}

void main()
{
  _Heap.n = 0;
  srand(time(NULL));
  printf("입력할 원소의 개수 : ");
  scanf("%d", &_Heap.n);
  for(int i =1; i <= _Heap.n; i++)
    _Heap.H[i] = rand() % 100 + 1;
  printHeap(); 
  buildHeap(); //상향식 힙 생성 
  printHeap();

  printf("제자리 정렬 수행\n");
  inPlaceHeapSort();
  printArray();
}