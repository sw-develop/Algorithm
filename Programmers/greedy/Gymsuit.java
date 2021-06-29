//주어진 배열들이 정렬되어 있지 않다

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        //lost: 잃어버린 학생 번호 배열, reserve: 여벌 옷 가지고 있는 학생 번호 배열 
        //lost와 reserve를 합쳐서 하나의 배열로 생각하기!
        int stu[] = new int[n];
        int answer = n; //전체 학생 수로 설정해두고 감소시키기 -> 증가시키는 경우보다 코드가 적어짐 
        
        for(int i : lost)
            stu[i-1]--;
        for(int j : reserve)
            stu[j-1]++;
            
        //그리디 문제인 이유 : 앞뒤 사람 모두 여유복을 가지고 있을 때, 앞 사람의 것을 빌려야 최대가 나옴
        for(int k = 0; k < stu.length; k++){
            if(stu[k] == -1){ //체육복을 도난당한 학생의 경우
                if(k-1 >= 0 && stu[k-1] == 1){ //앞 사람 먼저 확인  
                    stu[k]++;
                    stu[k-1]--;
                }
                else if(k+1 < stu.length && stu[k+1] == 1){
                    stu[k]++;
                    stu[k+1]--;
                }
                else answer--; //체육수업을 듣지 못하는 학생 
            }
        }
        return answer;
    }
}