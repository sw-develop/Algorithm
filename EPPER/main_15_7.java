import java.util.*;


class Pair implements Comparable<Pair>{
	int x; //시작시간
	int y; //종료시간 
	public Pair(int x, int y){
		this.x=x;
		this.y=y;
	}
	public int first(){return x;} //시작시간 반환 함수 
	public int second(){return y;} //종료시간 반환 함수
	
	@Override
	public int compareTo(Pair o){ //오름차순 정렬 -> 왜 이렇게 하는거지??? 
		if((this.second()-o.second()) == 0) //종료시간이 같을 때
			return this.first()-o.first(); //시작시간으로 비교 
		else 
			return this.second()-o.second();
			
		/*
		if(o.second() == this.second())
			return (o.first() < this.first())?1:0; //삼항연산자 사용 
		else return (o.second() < this.second())?1:0;
		*/
	}
}

public class main_15_7 {
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
		Collections.sort(list);
		
		//3.반복문으로 2개의 좌석에 학생 배치하기 	
		//문제)좌석에는 우선순위가 없지만 조건문에서는 1번째 좌석을 먼저 체크함 
		//해결)종료시간이 나중이면 시작시간도 나중이라고 가정해서 그런건가? 
		for(i=0; i<N; i++){
			if(e1 <= list.get(i).first()){ //1번째 좌석
				answer++;
				e1 = list.get(i).second();
			}
			else if(e2 <= list.get(i).first()){ //2번째 좌석
				e2 = e1;
				e1 = list.get(i).second();
				answer++;
			}
			//System.out.printf("e1 : %d e2 : %d\n", e1, e2);
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