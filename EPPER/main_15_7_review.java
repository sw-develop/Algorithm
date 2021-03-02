//1.사용 알고리즘 : 그리디 
//2.정렬 기준(가장 많은 인원이 사용할 수 있도록) : 종료시간이 빠른 순서대로
//시작시간 or (종료-시작)시간으로 하는 것보다 더 많은 인원이 사용 가능하기 때문
//조건)종료시간 동일 시 시작시간이 더 빠른 것 부터 
//2-1.어떻게 정렬을 할 것인가? 
//고려사항)종료시간 배열 정렬되는 동시에 시작시간 배열도 같이 정렬이 되어야 함
//생각)pair 사용하기 -> 방법) 직접 Pair 클래스 생성하기
//주의)특정 타입의 객체는 기본형 데이터와 달리 정렬 기준이 없으면 정렬을 할 수가 없으며, 따라서 정렬 기준을 정의하여 알려줘야 함
 
import java.util.*;

class Pair implements Comparable<Pair>{
  int x; //start time
  int y; //finish time
  public Pair(int x, int y){ //constructor
    this.x = x;
    this.y = y;
  }
  public int start(){return x;} //시작시간 반환 함수
  public int finish(){return y;} //종료시간 반환 함수 

  @Override
  public int compareTo(Pair p){ //정렬 기준 정의
    if((this.finish()- p.finish()) == 0)
      return this.start()-p.start();
    else
      return this.finish() - p.finish();
  }
}

public class Main {
	public static int solution(int[] s, int[]e, int N){
		int answer = 0;
		int i, j, tmp, e1 = -1, e2 = -1; //e1 & e1 : 종료 시간 저장 

    //pair 객체의 연결리스트 생성 -> 값 저장 및 접근 용이  
    List<Pair> list = new LinkedList<>();

    for(i=0; i<N; i++){
      Pair p = new Pair(s[i], e[i]); //시작&종료 시간 pair 생성
      list.add(p);
    }

    //종료시간 기준 오름차순 정렬
    Collections.sort(list);

    //반복문으로 2개의 좌석 학생 배치하기 
    //주의)좌석 간에는 우선순위가 없음 
  
		
		
		return answer;
	}	
  public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int s[] = new int[1000]; //시작시간
		int e[] = new int[1000]; //종료시간 
		int N;
		N = scan.nextInt();
		for(int i = 0; i < N; i++)
			s[i] = scan.nextInt();
		for(int i = 0; i < N; i++)
			e[i] = scan.nextInt();
		System.out.print(solution(s, e, N));
	}
}