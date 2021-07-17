// Complete the maxTickets function below.
//부분배열의 최대 크기 반환!
static int maxTickets(List<Integer> tickets) {
	  int maxSubSequenceSize = 0;
	 
    Collections.sort(tickets); //주어진 리스트 오름차순 정렬 

    startIndex = 0;
    listSize = tickets.size();
    while(startIndex < listSize) {
    	int compareIndex = startIndex + 1;
    	while(compareIndex < listSize && tickets[compareIndex] - tickets[compareIndex-1] <= 1)
    		compareIndex += 1;
    	maxSubSequenceSize = Math.max(maxSubSequenceSize, compareIndex - startIndex);
    	startIndex = compareIndex; //index 값 업데이트 
    }
    
    return maxSubSequenceSize;
}