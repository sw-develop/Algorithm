import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class PairComparable implements Comparable<PairComparable>{

	private int startTime;
    private int endTime;

    public PairComparable(int startTime, int endTime){
        this.startTime = startTime;
        this.endTime = endTime;
    }
    
    public int getStartTime() {
    	return startTime;
    }
    
    public void setStartTime(int startTime) {
    	this.startTime = startTime;
    }
    
    public int getEndTime() {
    	return endTime;
    }
    
    public void setEndTime(int endTime) {
    	this.endTime = endTime;
    }
    
	@Override
	public int compareTo(PairComparable o) {
		if(this.endTime - o.endTime == 0)
			return this.startTime - o.startTime;
		else 
			return this.endTime - o.endTime;
	}
}

public class ComparableEx{
	public static void main(String[] args) {
		List<PairComparable> list = new LinkedList<PairComparable>();
		
		PairComparable p1 = new PairComparable(1,4);
		PairComparable p2 = new PairComparable(2,3);
		PairComparable p3 = new PairComparable(3,5);
		
		list.add(p1);
		list.add(p2);
		list.add(p3);
		
		Collections.sort(list);
		
		for(PairComparable p : list) {
			System.out.println(p.getStartTime() + " " + p.getEndTime());
		}
	}
}


