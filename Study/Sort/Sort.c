#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define MAX_SIZE 10
#define SWAP(x,y,t) ((t)=(x), (x)=(y), (y)=(t)) //switch 위한 매크로 정의


//1.선택정렬 -> 가장 작은 값부터 찾아서 차례대로 정렬
//시간복잡도 : 이중for문 -> O(n^2)
void selection_sort(int list[], int n) {//인자: 정렬한 리스트 저장할 배열, 배열의 크기
	int i, j, least, temp;
	for (i = 0; i < n - 1;i++) {//배열의 시작부터 n-2까지(마지막 위치는 자동 정렬되니까)
		/*최소 값 찾기*/
		least = i; //최소값 위치 저장 변수, 아직 정렬되지 않은 첫번째 원소
		for (j = i + 1; j < n; j++)
			if (list[least] > list[j])
				least = j; //최소값 위치 찾기
		SWAP(list[least], list[i], temp); //정렬 안된 i번째 원소와 switch
	}

}

//2.삽입정렬
//시간복잡도) 최악(역순으로 되어있는 경우) : O(n^2), 최선(정렬되어 있는 경우) : O(n)
void insertion_sort(int list[], int n){
  int i, j, key;
  for(i=1; i<n; i++) //원시작업 : n
  {
    key = list[i]; //정렬 대상이 되는 원소
    for(j=i-1; j>=0 && list[j] > key; j--) //정렬 대상이 되는 i번째 원소 이전 값부터 비교 시작 
                                           //원시작업(최악) : 1 + 2 + ... + n-2, 원시작업(최선) : 1 + 1 + ... + 1 = n 
      list[j+1] = list[j];
    list[j+1] = key; //정렬 대상이었던 원소의 최종 위치
  }
}

//3.버블정렬
//원리) 인접한 2개의 레코드를 비교하여 크기 순대로 되어 있지 않으면 서로 교환 -> 배열의 끝에서부터 정렬됨 
//시간복잡도) O(n^2)
void bubble_sort(int list[], int n){
  int i, j, temp;
  for(i = n-1; i>0; i++){ //반복할 때마다 마지막 index는 최종정렬상태가 됨 
    for(j=0; j<i; j++) //원시작업 : n-2 + n-1 + n-3 + ... + 1 
      if(list[j] > list[j+1])
        SWAP(list[j], list[j+1], temp);
  }
}

//4.쉘정렬 -> 삽입 정렬이 어느 정도 정렬된 리스트에 대해 O(n)의 빠른 시간복잡도를 갖는 것에 착안 
//원리) 사용되는 정렬 알고리즘은 삽입 정렬인데, 삽입 정렬의 대상을 다르게 해줌 
void inc_insertion_sort(int list[], int first, int last, int gap){
  int i, j, key;
  for(i=first; i<=last; i+=gap)
  {
    key = list[i]; //정렬되어질 대상

    for(j = i-gap; j >= first && list[j] > key; j -= gap) //gap 주의!! 
      list[j+gap] = list[j];
  }
  list[j+gap] = key;
}

void shell_sort(int list[], int n){
  int i, gap; //gap : 부분리스트의 개수 
  for(gap = n/2; gap > 0; gap /= 2) //gap의 크기를 절반 씩 줄여나감 --> 부분리스트의 개수를 줄여감 
  {
    if(gap % 2 == 0) gap++; //gap이 홀수일 때 성능이 더 좋음
    for(i=0; i<gap; i++) //부분리스트 개수(=gap의 값)만큼 반복 
      inc_insertion_sort(list, i, n-1, gap); //삽입정렬 수행 
  }
}

//5.합병정렬 
//원리) 분할정복방식 (균등분할)
//시간복잡도) O(n*logn)
//단점) 추가공간필요(sorted[])
void merge(int list[], int left, int mid, int right){
  int i, j, k; //i, j : 반으로 분할된 두 리스트의 시작 Index, k : merge된 new list의 index
  i = left; j = mid+1; k = left; 
  while(i<=mid && j<=right){
    if(list[i] < list[j]) sorted[k++] = list[i++];
    else sorted[k++] = list[j++];
  }
  //남은 부분 리스트 처리해주기
  if(i>mid)
    while(j<=right) sorted[k++] = list[j++];
  else //index j의 부분리스트가 끝났을 때
    while(i<=mid) sorted[k++] = list[i++];
  for(i=left; i<=right; i++)
    list[i] = sorted[i];
}

void merge_sort(int list[], int left, int right){
  int mid;
  if(left < right)
  {
    mid = (left+right)/2; //list를 반으로 분할
    merge_sort(list, left, mid); //분할된 각각의 리스트에 대해 merge_sort 수행
    merge_sort(list, mid+1, right);
    merge(list, left, mid, right);
  }
}

//6.퀵정렬
//원리) 분할정복방식 (비균등분할)
//시간보잡도) 균등분할 시 : O(n*logn) / 극도로 비균등분할 시 : O(n^2)
int partition(int list[], int left, int right){ //left : 정렬할 부분리스트의 처음 index, right : 정렬할 부분리스트의 마지막 index
  int pivot = list[left]; //현재 가장 첫 번째 값을 pivot으로 설정
  int temp, low, high;
  low = left;
  high = right+1;
  do{
    do
      low++;
    while(list[low] > pivot); //pivot보다 큰 값 찾을 때까지 반복
    do 
      high--;
    while(list[high] < pivot); //pivot보다 작은 값을 찾을 때까지 반복 
  }while(low < high);
  SWAP(list[left], list[high], temp);
  return high; //pivot의 최종위치 반환 -> 더이상 위치 바뀌지 않음
}

void quick_sort(int list[], int left, int right){
  if(left < right)
  {
    int p = partition(list, left, right); //pivot의 최종 위치 반환
    quick_sort(list, left, p-1);
    quick_sort(list, p+1, right);
  }
}


int main(void) {
	int list[MAX_SIZE];
	int i, n;
	n = MAX_SIZE;
	srand(time(NULL));

	for (i = 0; i < n; i++) //난수 생성 및 출력
		list[i] = rand() % 100; //난수 발생 범위 0~99

	printf("\n<Before sorting>\n");
	for (i = 0; i < n; i++)
		printf("%d ", list[i]);

	selection_sort(list, n); //선택 정렬 호출

	printf("\n\n<After Selection Sorting>\n");
	for (i = 0; i < n;i++)
		printf("%d ", list[i]);
	printf("\n");
	return 0;
}