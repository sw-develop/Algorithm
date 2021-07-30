import java.util.*;

class Result {
    /*
     * Complete the 'maxEvents' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arrival
     *  2. INTEGER_ARRAY duration
     */
     public static int maxEvents(List<Integer> arrival, List<Integer>
duration) {
    // Write your code here
        List<Pair> companies = new LinkedList<>();
        for(int i = 0; i < arrival.size(); i++){
            Pair p = new Pair(arrival.get(i), arrival.get(i) +
duration.get(i));
            companies.add(p);
        }
        Collections.sort(companies); //객체 정렬 

        int count = 1;
        int endTime = companies.get(0).endTime;
        for(int i = 1; i < companies.size(); i++){
            if(companies.get(i).startTime < endTime) continue;
            else{
                count++;
                endTime = companies.get(i).endTime;
            }
        }   
        return count;
    }
}
class Pair implements Comparable<Pair>{
    int startTime;
    int endTime;

    public Pair(int startTime, int endTime){
        this.startTime = startTime;
        this.endTime = endTime;
    }
    
    @Override
    public int compareTo(Pair p){
        if((this.endTime - p.endTime) == 0) //끝나는 시간이 동일할 때 
            return this.startTime - p.startTime; //시작 시간이 빠른 것 기준 
        else
            return this.endTime - p.endTime;
    }
}