//기존 힙 생성 방식 
//Heap 구현
//- 완전이진트리 
//- 배열을 이용하여 구현 

//1. Heap 정의
#define MAX_ELEMENT 200

typedef struct{
  int key;
}element; //heap의 노드 구조체 정의

typedef struct{
  element heap[MAX_ELEMENT]; //완전이진트리 -> 배열로 구현 
  int heap_size;
}HeapType;

HeapType* create(){ //heap 생성 함수
  return (HeapType*)malloc(sizeof(HeapType)); //동적 할당
}

void init(HeapType* h){ //heap 초기화 함수 
  h->heap_size = 0;
}

HeapType * heap = create(); //동적 메모리 사용

//2. Heap 삽입 -> 배열로 구현할 경우, index 1부터 삽입
//시간 복잡도) 최악의 경우, 루트노드까지 올라가야 하므로 트리의 높이만큼의 비교연산 + 이동연산 -> O(logn)
//예시) 최대 힙인 경우 : key(부모노드) >= key(자식노드)
//과정 1. 새로운 노드를 힙의 마지막 노드에 이어서 삽입 -> 2. 삽입 후 부모 노드들과 크기 비교하여 최대 힙 성질 만족하도록 교환  
//upheap 알고리즘 
void insert_max_heap(HeapType* h, element item){
  int i; //삽입된 노드의 index 
  i = ++(h->heap_size);

  //힙 이진 트리를 거슬러 올라가며 부모 노드와 비교하는 과정
  while((i != 1) && (item.key > h->heap[i/2].key)){
    h->heap[i] = h->heap[i/2]; //부모 노드와 자식 노드 위치 바꾸기 
    i /= 2;
  }
  h->heap[i] = item;
}

//3. Heap 삭제 -> heap의 루트 노드가 삭제됨 
//시간 복잡도) 최악의 경우, O(logn)
//예시) 최대 힙인 경우
//과정 1. 루트 노드 삭제 -> 2. 마지막 노드를 루트 노드로 이동시킴 -> 3. 루트에서부터 단말 노드까지의 경로에 있는 노드들과 크기 비교하여 히프 성질 만족하도록 교환 
//downheap 알고리즘
element delete_max_heap(HeapType* h){
  int parent, child; //parent = 루트 노드로 이동된 마지막 노드의 index 저장 변수 
  element item, temp;

  item = h->heap[1]; //삭제된 루트 노드 저장 
  temp = h->heap[(h->heap_size)--]; //루트 노드로 이동된 마지막 노드 저장
  parent = 1;
  child = 2;
  while(child <= h->heap_size){
    //현재 노드의 자식 노드 중 더 큰 자식 노드 찾기 
    if((child < h->heap_size) && (h->heap[child].key < h->heap[child+1].key)) child++; //오른쪽 자식 노드의 값이 더 크다면 
    if(temp.key >= h->heap[child].key) break; //최대 힙 성질 만족
    else{ //최대힙 성질 만족 X -> 자식노드와 값 바꾸기
      h->heap[parent] = h->heap[child];
      //값 갱신하기 
      parent = child;
      child *= 2;
    }
  }
  h->heap[parent] = temp;
  return item; 
}

//Heap 정렬 
//과정) 1. 정렬해야 할 n개의 요소들을 최대 힙에 삽입 -> 2. 삭제 연산 수행하여 차례대로 저장(루트 노드의 값이 삭제되어 반환 됨) -> 3. 최대 힙이므로, 내림차순 정렬됨 
//시간복잡도) O(nlogn) -> n개의 요소에 대해
void heap_sort(element arr[], int n){ //arr : 정렬된 값 저장 배열 
  int i;
  HeapType* h;
  
  h = create();
  init(h);

  //1. insert -> create max_heap
  for(int i = 0; i<n; i++){
    insert_max_heap(h, arr[i]);
  }
  //2. delete -> create ordered array
  for(int i = (n-1); i>=0; i--){ //오름차순 정렬 
    a[i] = delete_max_heap(h);
  }
  free(h); //동적할당 했으니까 
}


