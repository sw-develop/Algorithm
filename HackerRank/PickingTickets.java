// Complete the maxTickets function below.
//부분배열의 최대 크기 반환!
static int maxTickets(List<Integer> tickets) {
int maxArrSize = 0; //배열 크기 반환 Collections.sort(tickets);
     int beforeVal = 0;
     int beforeArrSize = 1;
     beforeVal = tickets.get(0);
     for(int i = 1; i < tickets.size(); i++){
         int difference = tickets.get(i) - beforeVal;
         beforeVal = tickets.get(i);
         if(difference == 0 || difference == 1) {
             beforeArrSize++;
         }
         else if(difference != 0 && difference != 1) {
             if(maxArrSize < beforeArrSize)
                 maxArrSize = beforeArrSize;
             beforeArrSize = 1;
         }
     }
     return maxArrSize;
}