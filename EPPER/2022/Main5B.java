import java.util.Arrays;

class Solution {
  public int solution(int n, int[] lost, int[] reserve) {
    int answer = 0;

    // 학생별 소유한 체육복 개수 계산
    int[] clothes = new int[n + 2];
    Arrays.fill(clothes, 1);

    for (int i : lost) {
      clothes[i]--;
    }
    for (int i : reserve) {
      clothes[i]++;
    }

    // 왼쪽(앞번호) 학생에게 우선 빌리기
    for (int i = 1; i <= n; i++) {
      if (clothes[i] == 0) {
        if (clothes[i - 1] == 2) { // 왼쪽 학생
          clothes[i - 1]--;
          clothes[i]++;
        } else { // 오른쪽 학생
          if (clothes[i + 1] == 2) {
            clothes[i + 1]--;
            clothes[i]++;
          }
        }
      }
    }

    // 계산
    for (int i = 1; i <= n; i++) {
      if (clothes[i] >= 1)
        answer++;
    }

    return answer;
  }
}