import java.util.*;

class Solution {
    
    static boolean board[][][];
    
    //현재 상태가 조건에 만족하는지 (x, y) 중심으로 확인
    public static boolean validate(int x, int y, int a, int n) {
        if (a == 0) { //기둥 
            if (y == 0) { //바닥 위
                return true;
            }
            if (board[x][y][1] || board[x-1][y][1]) { //보의 왼쪽 or 오른쪽 끝 위
                return true;
            }
            if (y > 0 && board[x][y-1][0]) { //다른 기둥 위
                return true;
            }
        } else { //보
            if (y > 0 && board[x][y-1][0]) { //왼쪽 끝이 기둥 위
                return true;
            }
            if (x < n && y > 0 && board[x+1][y-1][0]) { //오른쪽 끝이 기둥 위
                return true;
            }
            if (x > 0 && x < n && board[x-1][y][1] && board[x+1][y][1]) { //양쪽 끝이 보와 연결
                return true;
            }
        }
        return false;
    }
    
    //(x, y) 구조물을 삭제할 수 있는지 확인
    public static boolean checkRemovable(int x, int y, int n) {
        //삭제시킨 구조물의 좌표의 인접한 구조물이 여전히 조건을 만족하는지 확인하도록 하고, 이때 모든 방향을 확인하도록 함 
        int[] dx = {-1, 0, 1};
        int[] dy = {-1, 0, 1};
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int nx = x + dx[i];
                int ny = y + dy[j];
                if (nx < 0 || nx > n || ny < 0 || ny > n) {
                    continue;
                }
                for (int k = 0; k < 2; k++) {
                    if (board[nx][ny][k] && !validate(nx, ny, k, n)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    public int[][] solution(int n, int[][] build_frame) {
        //새로운 값 추가를 편하게 하기 위한 List 사용
        ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();
        //현재 설치 현황 나타내는 보드 초기화
        board = new boolean[n + 1][n + 1][2];
        //시뮬레이션
        for (int i = 0; i < build_frame.length; i++) {
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int a = build_frame[i][2];
            int cmd = build_frame[i][3];
            if (cmd == 0) { //삭제
                board[x][y][a] = false;
                //삭제할 수 없으면
                if (!checkRemovable(x, y, n)) {
                    board[x][y][a] = true;
                }
            } else if (validate(x, y, a, n)) { //설치 가능한 경우
                board[x][y][a] = true;
            }
        }
        //결과
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k < 2; k++) {
                    if (board[i][j][k]) {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(i);
                        temp.add(j);
                        temp.add(k);
                        answer.add(temp);
                    }
                }
            }
        }
        //List를 배열로 변환해서 반환
        int[][] ans = new int[answer.size()][3];
        for (int i = 0; i < answer.size(); i++) {
            for (int j = 0; j < answer.get(i).size(); j++) {
                ans[i][j] = answer.get(i).get(j);
            }
        }
        return ans;
    }
}