import java.util.*;

class Pair{
    public int x;
    public int y;
    
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Result {

    /*
     * Complete the 'reachTheEnd' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING_ARRAY grid
     *  2. INTEGER maxTime
     */
    
    public static int dx[] = {-1, 1, 0, 0}; //row (상하좌우)
    public static int dy[] = {0, 0, -1, 1}; //col (상하좌우)
    
    public static char unblocked = '.';
    public static char blocked = '#';
    
    public static int countTimeinMap(char charMap[][], int intMap[][], int x, int y) {
        //using BFS
        Queue<Pair> queue = new LinkedList<>(); //큐 생성 
        queue.offer(new Pair(x, y)); //enqueue
        
        while(!queue.isEmpty()) {
            Pair p = queue.poll(); //dequeue 
            x = p.x;
            y = p.y;
            
            for(int i = 0; i < dx.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0 || nx >= charMap.length || ny < 0 || ny >= charMap[0].length) continue; //Map의 범위를 벗어난 경우 
                if(charMap[nx][ny] == blocked) continue; //막힌 cell인 경우  
                else {
                    if(intMap[nx][ny] == 0){ //방문한 적이 없을 때 
                        intMap[nx][ny] = intMap[x][y] + 1; //가중치 증가 
                        queue.offer(new Pair(nx, ny)); //enqueue 
                    }  
                }
            }
        }    
            
        return intMap[charMap.length-1][charMap[0].length-1]; //도착 지점의 가중치 반환 
    }

    public static String reachTheEnd(List<String> grid, int maxTime) {
    // Write your code here
        int rowSize = grid.size();
        int colSize = grid.get(0).length();
        
        char charMap[][] = new char[rowSize][colSize]; 
        int intMap[][] = new int[rowSize][colSize]; //가중치 저장용 배열  
        
        //charMap 채우기 (String to Int)
        for(int i = 0; i < rowSize; i++) {
            String str = grid.get(i);
            for(int j = 0; j < colSize; j++) {
                charMap[i][j] = str.charAt(j);
            }
        }
        
        if(rowSize == 1 && colSize == 1){
            if(charMap[rowSize-1][colSize-1] == unblocked) return "Yes";
            else return "No";
        }
        else{
            int time = countTimeinMap(charMap, intMap, 0,0);
            if(time != 0 && time <= maxTime) return "Yes"; //조건 만족 시 
            else return "No";
        }
    }
}


