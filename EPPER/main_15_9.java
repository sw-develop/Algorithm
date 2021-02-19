import java.util.*;
class Main {
	//solution 함수를 완성하세요. 
	//위상정렬 알고리즘 사용 
	//->전체 노드를 순서 위배하지 않고 정렬하는 것이므로 전체를 정렬하는 것임 -> 개선 가능하지 않을까?
	//사용 자료구조 : 그래프 & 스택 or 큐
	
	//생각1) time[] 선언해서 모든 정점의 공정시간을 저장함 -> 기존의 위상정렬 코드 while문 안에서 time 처리만 추가해주면 됨 

	//생각2) 찾는 정점 1개의 시간만 계산하기 -> 이게 불가능 -> 최종 노드가 어떤 노드랑 연결이 되어있는지 모름 
	
	public static int solution(int[] n,int[][] r,int goal){
		int answer=0;
		int in_degree[] = new int[n.length+1]; //진입 차수 저장 배열 -> 0으로 초기화 됨 
		int stack[] = new int[n.length]; //스택 - 배열로 구현
		int adj[][] = new int[n.length+1][n.length+1]; //간선 그래프 - 인접 행렬로 구현 
		int time[] = new int[n.length+1]; //공정 시간 저장 배열 -> 각 노드 별 
		
		int idx = 0; //스택 배열 index 
		int i;
		int pop = 0; //스택에서 pop한 값 
		int node = 0;
		
		//1.인접행렬 & in_degree 배열 채우기(진입차수 계산)
		for(i=0; i<r.length; i++){
			int u = r[i][0]; //index 1부터 시작
			int v = r[i][1]; //index 1부터 시작 
			adj[u][v] = 1; //간선이 존재하는 경우 (u->v)
			in_degree[v]++;
		}
		
		//2.in_degree == 0인 노드 스택에 push (초기 스택 설정)
		for(i = 1; i<in_degree.length; i++) // i : 노드 번호 
			if(in_degree[i] == 0) {
				if(i == goal) { //최종 노드일 때
					answer += n[i-1]; //자신의 가중치 더하기 
					return answer;
				}
				time[i] = n[i-1];
				stack[idx++] = i;
			}
		
		//3.스택에서 pop하며 in_degree 배열 재정비 및 계산 
		while(idx != 0){
			pop = stack[--idx]; //노드번호  
			
			//in_degree 배열 재정비 -> 2차원 배열에서 간선 찾아서 재정비
			for(i=1; i<adj.length; i++){
				if(adj[pop][i]==1){ //인접행렬에서 간선으로 연결된 노드의 진입차수 재정비 
					time[i] = Math.max(time[i], time[pop]+n[i-1]);
					in_degree[i]--;
					if(in_degree[i]==0) stack[idx++]=i;
				}
			}
		}
		
		answer = time[goal];
		
		return answer;
		
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt(); //노드 수
		int R=sc.nextInt(); //간선 수 
		int[] n = new int[N]; //가중치 배열
		int [][] r=  new int[R][R]; //간선 배열 
		
		for(int i=0;i<N;i++) { //가중치 입력
			n[i]=sc.nextInt(); 
		}
		for(int k=0;k<R;k++) {
			for(int j=0;j<2;j++) {
				r[k][j]=sc.nextInt();
			}
		}
		
		int goal=sc.nextInt(); //최종 공정 목표 노드 번호 
		int k=solution(n,r,goal);
		System.out.println(k);
		
	}
}