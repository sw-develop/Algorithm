import java.util.*;

public class Main {

    public static int INF = (int) 1e9;

    public static int numOfNode, numOfEdge;

    // 2차원 배열로 그래프 표현 (그래프 겸 최단 거리 테이블)
    public static int[][] graph = new int[101][101]; // 문제 조건에서 노드의 개수 <= 100

    public static void main(String[] args){
        Scanner kbd = new Scanner(System.in);

        numOfNode = kbd.nextInt();
        numOfEdge = kbd.nextInt();

        // 2차원 배열 - 무한으로 초기화
        for(int i = 0; i <= numOfNode; i++){
            Arrays.fill(graph[i], INF);
        }

        // 2차원 배열 - 자기 자신으로 가는 경로에 대해서는 0으로 설정
        for(int i = 1; i <= numOfNode; i++){
            for(int j = 1; j <= numOfNode; j++){
                if(i == j) graph[i][j] = 0;
            }
        }

        // 2차원 배열 - 노드 간의 관계 채우기
        for(int i = 0; i < numOfEdge; i++){
            int a = kbd.nextInt();
            int b = kbd.nextInt();
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        int x = kbd.nextInt();
        int k = kbd.nextInt();

        // 플로이드 워셜
        for(int i = 1; i <= numOfNode; i++){
            for(int a = 1; a <= numOfNode; a++){
                for(int b = 1; b <= numOfNode; b++){
                    graph[a][b] = Math.min(graph[a][b], graph[a][i] + graph[i][b]);
                }
            }
        }

        int result = graph[1][k] + graph[k][x];
        if(result >= INF) System.out.println(-1);
        else System.out.println(result);
    }

}

/*
[Input Example]
5 7
1 2
1 3
1 4
2 4
3 4
3 5
4 5
4 5

[Output Example]
3
*/