#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define SIZE 15

/*1. 사전 자료구조 생성 */
typedef struct
{
  int key;
  char value[10];
}element; //key, value

typedef struct{
  element dict[SIZE]; //리스트로 구현
  int size;
}DictType;

void init(DictType* d)
{
  d->size = 0; //원소 개수 초기화
}

//키 값 생성 함수
void insertKey(DictType* d){
  for(int i = 0; i < SIZE; i++){
    d->dict[i].key = rand() % 30 + 1; //1~30

    //키 중복값 제거 -> 유일키로 구성
    for(int j = 0; j < i; j++)
      if(d->dict[i].key == d->dict[j].key) 
        i--;
  }
}

//value 값 생성 함수
void insertValue(DictType* d){
  for(int i = 0; i < SIZE; i++)
  {
    for(int j = 0; j < 5; j++)
      d->dict[i].value[j] = rand() %  26 + 97;
    d->size++; //Dictionary의 원소 개수 1 증가 
  }
}

void makeDict(DictType* d){
  insertKey(d);
  insertValue(d);
}

void printDict(DictType* d)
{
  printf("<key, value>\n");
  for(int i = 0; i < d->size; i++)
  {
    printf("%2d ", d->dict[i].key); //key
    for(int j = 0; j < 5; j++) //value
      printf("%c", d->dict[i].value[j]);
    printf("\n");
  }
}

/*2. KEY 값을 기준으로 정렬 */
void insertion_sort(DictType* d) //삽입정렬 
{
  int i, j;
  element item;
  for(i = 1; i < SIZE; i++)
  {
    item = d->dict[i]; 
    for(j = i-1; j>=0 && d->dict[j].key > item.key; j--)
      d->dict[j+1] = d->dict[j];
    d->dict[j+1] = item;
  }
}

/*3. 이진 탐색 */
//재귀
int rFindElement(DictType* d, int key, int l, int r)
{
  int mid;
  if(l<=r){
    mid = (l+r)/2; //배열의 중간값 
    if(key == d->dict[mid].key) //key 찾았을 때
      return mid;
    else if(key < d->dict[mid].key) 
      return rFindElement(d, key, l, mid-1); //탐색 범위 조정해 재귀호출
    else
      return rFindElement(d,key, mid+1, r);
  }

  return -1;
}

//반복
int FindElement(DictType* d, int key, int l, int r)
{
  int mid;
  while(l<=r){
    mid = (l+r)/2; //배열의 중간값 
    if(key == d->dict[mid].key) //key 찾았을 때
      return mid;
    else if(key < d->dict[mid].key) 
      r = mid - 1;
    else
      l = mid + 1;
  }
  return -1;
}


int main(){
  DictType d;
  init(&d);
  srand(time(NULL)); //난수 발생
  makeDict(&d); //순서사전 만들기 
  printDict(&d);
  getchar();
  insertion_sort(&d); //삽입정렬 
  printDict(&d);
  getchar();

  printf("\n검색할 키 값을 입력 : ");
  int key;
  scanf("%d", &key);
  int index = FindElement(&d, key, 0, SIZE-1); //위치 저장
  if(index == -1) printf("검색실패\n");
  else{
    printf("\n위치 %d에서 키 : %d, 값 : ", index+1, key);
    for(int j = 0; j<5; j++)
      printf("%c", d.dict[index].value[j]);
    printf(" 검색성공\n");
  }
  
  return 0;
}
