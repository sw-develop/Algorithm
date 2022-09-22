import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        //각 학생이 가지고 있는 체육복의 개수 계산
        int[] clothes = new int[n + 2];
        Arrays.fill(clothes, 1);
        
        for (int i : lost) {
            clothes[i]--;
        }
        for (int i : reserve) {
            clothes[i]++;
        }
        
        //왼쪽 학생부터 양 옆의 학생에게 빌릴 수 있는지 확인
        for (int i = 1; i <= n; i++) {
            if (clothes[i] > 0) { //체육복이 있으면 pass
                continue;
            }
        
            if (clothes[i-1] == 2) { //왼쪽 학생에게 빌릴 수 있을 때
                clothes[i-1]--;
                clothes[i]++;
            } else if (clothes[i+1] == 2) { //오른쪽 학생에게 빌릴 수 있을 때
                clothes[i+1]--;
                clothes[i]++;
            }
        }
        
        //체육복을 1개 이상 가진 학생 수 계산
        for (int i = 1; i <= n; i++) {
            if (clothes[i] >= 1) {
                answer++;
            }
        }
        
        return answer;
    }
}