import java.util.*;

class Pair {
	int x; //시작시간
	int y; //종료시간 
	public Pair(int x, int y){
		this.x=x;
		this.y=y;
	}
	public int start(){return x;} //시작시간 반환 함수 
	public int finish(){return y;} //종료시간 반환 함수
}

public class Main {
	public static int solution(int[] s, int[]e, int N){
		int answer = 0;
		int i, j, tmp, e1 = -1, e2 = -1; //e1 & e1 : 종료 시간 저장 
		
		//조건) 종료시간 동일 시 시작시간이 더 빠른 것 부터 
		//생각)2차원 배열 정렬로 생각하기 -> 이거 안되는 거 같음 
		//생각)pair 로 생각하기
		
		//1.pair 생성
		List<Pair> list = new LinkedList<>();
		
		for(i = 0; i<N; i++){
			Pair p = new Pair(s[i], e[i]);
			list.add(p);
		}
		
		//2.종료시간 기준으로 오름차순 정렬 -> s[]와 e[] 동시에 정렬해줘야 함
    //정렬 기준: comparator 인터페이스 & compare() 사용
    //익명클래스 이용
		Comparator<Pair> myComparator = new Comparator<Pair>(){
			@Override
			public int compare(Pair p1, Pair p2){
    		if((p1.finish()- p2.finish()) == 0)
      		return p1.start()-p2.start();
    		else
      		return p1.finish() - p2.finish();
			} 
		};
		Collections.sort(list, myComparator);
		
		//3.반복문으로 2개의 좌석에 학생 배치하기 	
		for(i=0; i<N; i++){
			if(e1 <= list.get(i).start()){ //1번째 좌석
				answer++;
				e1 = list.get(i).finish();
			}
			else if(e2 <= list.get(i).start()){ //2번째 좌석
				e2 = e1;
				e1 = list.get(i).finish();
				answer++;
			}
		}
		return answer;
	}
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int s[] = new int[1000];
		int e[] = new int[1000];
		int N;
		N = scan.nextInt();
		for(int i = 0; i < N; i++)
			s[i] = scan.nextInt();
		for(int i = 0; i < N; i++)
			e[i] = scan.nextInt();
		System.out.print(solution(s, e, N));
	}
}