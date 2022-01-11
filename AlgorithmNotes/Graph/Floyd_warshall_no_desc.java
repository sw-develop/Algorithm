import java.util.*;

public class Main {
    public static final int INF = (int) 1e9;  
    
    public static int numOfNode, numOfEdge;
    
    public static int[][] graph = new int[501][501];

    public static void main(String[] args){
        Scanner kbd = new Scanner(System.in);

        numOfNode = kbd.nextInt();
        numOfEdge = kbd.nextInt();

        for(int i = 0; i < 501; i++){
            Arrays.fill(graph[i], INF);
        }

        for(int a = 1; a <= numOfNode; a++){
            for(int b = 1; b <= numOfNode; b++){
                if(a == b)  graph[a][b] = 0;
            }
        }

        for(int i = 0; i < numOfEdge; i++){
            int a = kbd.nextInt();
            int b = kbd.nextInt();
            int c = kbd.nextInt();
            graph[a][b] = c;
        }

        for(int k = 1; k <= numOfNode; k++){
            for(int a = 1; a <= numOfNode; a++){
                for(int b = 1; b <= numOfNode; b++){
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        for(int a = 1; a <= numOfNode; a++){
            for(int b = 1; b <= numOfNode; b++){
                if(graph[a][b] == INF){ 
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