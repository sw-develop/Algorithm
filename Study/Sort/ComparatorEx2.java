import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class PairComparator {
	private int startTime;
    private int endTime;

    public PairComparator(int startTime, int endTime){
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
}

//구현2-2) 익명 클래스 사용 
public class ComparatorEx2 {
	public static void main(String[] args) {
			List<PairComparator> list = new LinkedList<PairComparator>();
			
			PairComparator p1 = new PairComparator(1,4);
			PairComparator p2 = new PairComparator(2,3);
			PairComparator p3 = new PairComparator(3,5);
			
			list.add(p1);
			list.add(p2);
			list.add(p3);
			
			Comparator<PairComparator> myComparator = new Comparator<PairComparator>() {
				@Override
				public int compare(PairComparator o1, PairComparator o2) {
					if(o1.getEndTime() - o2.getEndTime() == 0)
						return o1.getStartTime() - o2.getStartTime();
					else
						return o1.getEndTime() - o2.getEndTime();
				}	
			};
			
			Collections.sort(list, myComparator);
			
			for(PairComparator p : list) {
				System.out.println(p.getStartTime() + " " + p.getEndTime());
			}
	}
}