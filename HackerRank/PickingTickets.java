// Complete the maxTickets function below.
//부분배열의 최대 크기 반환!
static int maxTickets(List<Integer> tickets) {
	 int maxSubSequenceSize = 0;
	 
     Collections.sort(tickets); //주어진 리스트 오름차순 정렬 
     
     int beforeVal = 0;
     int subSequenceSize = 1;
     beforeVal = tickets.get(0); //리스트의 첫 번째 원소부터 시작 
     for(int i = 1; i < tickets.size(); i++){
         int difference = tickets.get(i) - beforeVal; //j+1 - j
         beforeVal = tickets.get(i);
         if(difference <= 1) { //주어진 조건 만족 시
             beforeArrSize++; //부분배열 크기 증가 
         }
         else {
             if(maxSubSequenceSize < subSequenceSize)
                 maxSubSequenceSize = subSequenceSize; //부분 배열 최대 크기 업데이트 
             subSequenceSize = 1; //부분 배열 크기 초기화 
         }
     }
     return maxSubSequenceSize;
}