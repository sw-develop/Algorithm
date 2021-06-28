//주어진 배열들이 정렬되어 있지 않다
import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        //lost: 잃어버린 학생 번호 배열, reserve: 여벌 옷 가지고 있는 학생 번호 배열 
        int answer = 0;
        
        answer = n - lost.length; //체육복 도난당하지 않은 애들 
        
        //주어진 lost, reserve 배열 오름차순 정렬하기 
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        //여벌 옷 가지고 있는 학생 중 체육복을 잃어버린 학생 찾기
        int j = 0, k = 0, i = 0;
        for(i = 0; i < lost.length; i++){
            for(j=k; j<reserve.length; j++){
                if(lost[i] == reserve[j]){
                    reserve[j] = 0; 
                    lost[i] = 0;
                    answer++; 
                    k = j+1; //k값 재설정 
                }
                if(reserve[j] == 0) break; 
            }
        }
        
        //앞에 번호 애꺼를 빌리기
        int index1=0, index2=0; //lost와 reserve의 인덱스
        int check = 0; //빌리기 성공하면 1
        while(index1 < lost.length){ 
            int lost_num = lost[index1];
        
            if(lost_num == 0){
                index1++;
                continue;
            }
            
            for(i = index2; i < reserve.length; i++){
                if(reserve[i] == 0) {
                    continue; //다음 반복으로 
                }
                if(lost_num > reserve[i])
                    if(reserve[i] == lost_num-1) check = 1;
                else if(lost_num < reserve[i])
                    if(reserve[i] == lost_num+1) check = 1;
                else check = 1;
                
                if(check == 1){
                    answer++;
                    index2 = i+1; //다음번 reserve 배열 값 체크 위치 
                    break;
                }
            }
            
            
            if(check == 1) check = 0; //check 값 초기화 
            
            index1++;
        }
        
        
        return answer;
    }
}