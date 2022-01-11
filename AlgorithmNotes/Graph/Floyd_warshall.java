import java.util.*;

public class Main {
    public static final int INF = (int) 1e9;  // 무한을 의미하는 값으로 10억을 설정
    // 노드의 개수, 간선의 개수
    // 노드 개수는 최대 500개로 가정
    public static int numOfNode, numOfEdge;
    // 2차원 배열(그래프 표현)
    public static int[][] graph = new int[501][501];

    public static void main(String[] args){
        Scanner kbd = new Scanner(System.in);

        numOfNode = kbd.nextInt();
        numOfEdge = kbd.nextInt();

        // 최단 거리 테이블을 모두 무한으로 초기화
        for(int i = 0; i < 501; i++){
            Arrays.fill(graph[i], INF);
        }

        // 자기 자신 -> 자기 자신 으로 가는 비용은 0으로 초기화
        for(int a = 1; a <= numOfNode; a++){
            for(int b = 1; b <= numOfNode; b++){
                if(a == b)  graph[a][b] = 0;
            }
        }

        // 각 간선에 대한 정보를 입력 받아, 그 값으로 초기화
        for(int i = 0; i < numOfEdge; i++){
            // A에서 B로 가는 비용은 C라고 설정
            int a = kbd.nextInt();
            int b = kbd.nextInt();
            int c = kbd.nextInt();
            graph[a][b] = c;
        }

        // 점화식에 따라 플로이드 워셜 알고리즘 수행
        for(int k = 1; k <= numOfNode; k++){
            for(int a = 1; a <= numOfNode; a++){
                for(int b = 1; b <= numOfNode; b++){
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        // 수행 결과 출력 (2차원 배열 출력)
        for(int a = 1; a <= numOfNode; a++){
            for(int b = 1; b <= numOfNode; b++){
                if(graph[a][b] == INF){ // 도달할 수 없는 경우
                    System.out.print("INFINITY ");
                }
                else{
                    System.out.print(graph[a][b] + " ");
                }
            }
            System.out.println();
        }
    }
}

/*4
[Input Example]
7
1 2 4
1 4 6
2 1 3
2 3 7
3 1 5
3 4 4
4 3 2

[Output Example]
0 4 8 6
3 0 7 9
5 9 0 4
7 11 2 0
*/