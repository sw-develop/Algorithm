import java.util.*;
class main_15_9 {
  //키워드 : 선후관계 
  //사용 알고리즘 : 위상정렬 
	//사용 자료구조 : 그래프 & 스택 or 큐
  //그래프 - 인접 행렬로 구현, 스택 - 배열로 구현 

	//생각1) time[] 선언해서 모든 정점의 공정시간을 저장함 -> 기존의 위상정렬 코드 while문 안에서 time 처리만 추가해주면 됨 

	//생각2) 찾는 정점 1개의 시간만 계산하기 -> 이게 불가능 -> 최종 노드가 어떤 노드랑 연결이 되어있는지 모름 
	
	public static int solution(int[] n,int[][] r,int goal){
		int answer=0;
    //그래프 
    int in_degree[] = new int[n.length+1]; //진입 차수 
    int adj[][] = new int[n.length+1][n.length+1]; //간선 그래프 - 인접행렬로 구현
    //스택
    int stack[] = new int[n.length];
    int time[] = new int[n.length+1];

    int i = 0;
    int idx = 0; //스택 배열의 index

    //1.인접 행렬 & in_degree 배열 채우기(진입 차수 계산)
    for(i = 0; i<r.length; i++){
      int u = r[i][0];
      int v = r[i][1];
      adj[u][v] = 1; //간선이 존재하는 경우(u->v)
      in_degree[v]++; //진입차수 더하기 
    }

    //2.in_degree == 0 인 정점 스택에 push(초기 스택 설정)
    for(i=1; i<in_degree.length; i++){
      if(in_degree[i] == 0) {
        stack[idx++] = i;
        time[i] = n[i-1]; //공정 시간 설정
      }
    }

    //3.스택에서 pop하며 in_degree 배열 재정비 및 계산 
    while(idx != 0){
      int val = stack[--idx]; //pop된 값

      for(i=1; i<adj.length; i++){
        //간선이 존재할 때
        if(adj[val][i] == 1){
          in_degree[i]--;
          if(in_degree[i]==0) stack[idx++] = i;
          time[i] = Math.max(time[i], time[val]+n[i-1]);
        }
      }
    }

    answer = time[goal];
		
		return answer;
		
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt(); //정점 수
		int R=sc.nextInt(); //간선 수 
		int[] n = new int[N]; //가중치 배열
		int [][] r=  new int[R][R]; //간선 관계 배열  
		
		for(int i=0;i<N;i++) { //가중치 입력
			n[i]=sc.nextInt(); 
		}
		for(int k=0;k<R;k++) {
			for(int j=0;j<2;j++) {
				r[k][j]=sc.nextInt(); //정점 입력 
			}
		}
		
		int goal=sc.nextInt(); //최종 공정 목표 정점 번호 
		int k=solution(n,r,goal);
		System.out.println(k);
		
	}
}