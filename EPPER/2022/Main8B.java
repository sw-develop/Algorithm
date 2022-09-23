import java.util.ArrayList;

class Solution {
    
    static ArrayList<ArrayList<Integer>> adList = new ArrayList<ArrayList<Integer>>();
    static int answer = 1; //0번 노드에는 무조건 양이니까
    
    public static void dfs(int[] info, int currIdx, int sheep, int wolf, ArrayList<Integer> nextNode) {
        //1. (해당 경우에 대한) 재귀 끝낼 조건
        //늑대의 수 >= 양의 수 가 되어 양의 개수가 0으로 초기화될 때 끝냄
        if (info[currIdx] == 0) sheep++;
        else wolf++;
        
        answer = Math.max(answer, sheep); //최대 양의 수 업데이트
        
        if (wolf >= sheep) return; //최대 양의 수를 구하는 것이니까
        
        //2. 재귀 수행
        for (int i = 0; i < nextNode.size(); i++) {
            //다음 노드가 방문할 방문 노드 리스트 구성
            //별도로 구성하는 이유 : 문제의 조건에서 해당 노드와 직접 연결된 노드 외에 부모 노드와 연결된 노드로도 탐색 가능하기 때문임
            ArrayList<Integer> next = new ArrayList<>();
            for (int j = 0; j < nextNode.size(); j++) {
                next.add(nextNode.get(j));
            }
            next.remove(i); //다음에 방문할 대상 노드는 방문 노드 리스트에서 삭제
            for (int j = 0; j < adList.get(nextNode.get(i)).size(); j++) {
                next.add(adList.get(nextNode.get(i)).get(j));
            }
            
            dfs(info, nextNode.get(i), sheep, wolf, next);
        }
        return;
    }
    
    public int solution(int[] info, int[][] edges) {
        //인접리스트 구성
        for (int i = 0; i < info.length; i++) {
            adList.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            adList.get(edges[i][0]).add(edges[i][1]);
        }
        
        //0번 노드와 연결된 노드들을 방문 노드 리스트에 추가
        ArrayList<Integer> nextNode = new ArrayList<>();
        for (int i = 0; i < adList.get(0).size(); i++) {
            nextNode.add(adList.get(0).get(i));
        }
        
        //dfs 수행
        dfs(info, 0, 0, 0, nextNode);
        return answer;
    }
}