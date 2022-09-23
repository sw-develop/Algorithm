import java.util.ArrayList;
import java.lang.Math;

class Solution {
    
    public static int dfs(int currIdx, int wolf, int sheep, ArrayList<Integer> nextNode, int[] info, ArrayList<Integer>[] adList, int answer) {
        //양과 늑대 마리 수 업데이트
        if (info[currIdx] == 0) sheep++;
        else wolf++;
        
        //디버깅
        System.out.println("node : " + currIdx);
        System.out.println("sheep : " + sheep);
        System.out.println("wolf : " + wolf);
        
        //양의 마리 수 최대값 갱신
        answer = Math.max(answer, sheep);
        
        //늑대 수 >= 양의 수 이면, return
        if (wolf >= sheep) return answer;
        
        //현재 방문 가능한 노드들을 순차적으로 방문
        for (int i = 0; i < nextNode.size(); i++) {
            ArrayList<Integer> next = new ArrayList<>();
            for (int j = 0; j < nextNode.size(); j++) {
                next.add(nextNode.get(j));
            }
            next.remove(i); //다음 방문 노드는 방문 가능 노드 배열에서 삭제
            
            for (int j = 0; j < adList[nextNode.get(i)].size(); j++) {
                next.add(adList[nextNode.get(i)].get(j));
            }
            answer = dfs(nextNode.get(i), wolf, sheep, next, info, adList, answer);
        }
        
        return answer;
    }
    
    public int solution(int[] info, int[][] edges) {
        //인접리스트 구성
        ArrayList<Integer>[] adList = new ArrayList[info.length];
        for (int i = 0; i < info.length; i++) {
            adList[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < edges.length; i++) {
            adList[edges[i][0]].add(edges[i][1]);
        }
        
        //다음에 방문 가능한 노드 저장
        ArrayList<Integer> nextNode = new ArrayList<>();
        for (int i = 0; i < adList[0].size(); i++) {
            nextNode.add(adList[0].get(i));
        }
        
        //탐색 수행
        int answer = 1;
        answer = dfs(0, 0, 0, nextNode, info, adList, answer);
        return answer;
    }
}