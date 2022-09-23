import java.util.Arrays;

class Solution {

  static int maxDiff = 0;

  public static boolean compare(int[] ryan, int[] answer) {
    for (int i = 10; i >= 0; i--) {
      if (ryan[i] > answer[i])
        return true;
      else if (ryan[i] < answer[i])
        return false;
      // 맞힌 개수가 동일한 경우 그 다음으로 낮은 점수에 대한 개수 비교 계속 수행
    }
    return false;
  }

  public static void calcScore(int[] ryan, int[] appeach, int[] answer) {
    // 최종 점수 계산
    int ryanScore = 0;
    int appeachScore = 0;
    for (int i = 0; i < 11; i++) {
      if (ryan[i] > appeach[i]) {
        ryanScore += 10 - i;
      } else if (appeach[i] > 0) {
        appeachScore += 10 - i;
      }
    }
    // 최대 점수차 갱신 확인
    int diff = ryanScore - appeachScore;
    if (diff > 0 && diff >= maxDiff) {
      // 최대 점수차가 동일한 경우, 가장 낮은 점수를 맞힌 개수 비교
      if (diff == maxDiff && !compare(ryan, answer))
        return;
      // 갱신
      maxDiff = diff;
      for (int i = 0; i < 11; i++) {
        answer[i] = ryan[i];
      }
    }
  }

  // DFS를 사용한 완전탐색
  public static void shoot(int idx, int arrows, int[] ryan, int[] appeach, int[] answer) {
    // 재귀 끝낼 조건
    if (idx == 11 || arrows == 0) {
      ryan[10] += arrows; // 남은 화살 처리
      calcScore(ryan, appeach, answer);
      ryan[10] -= arrows; // 다음 탐색을 위해 화살 되돌려놓기
      return;
    }
    // 재귀 수행
    if (arrows > appeach[idx]) { // 라이언이 화살을 쏘는 경우 (점수 획득)
      ryan[idx] += appeach[idx] + 1;
      shoot(idx + 1, arrows - appeach[idx] - 1, ryan, appeach, answer);
      ryan[idx] -= appeach[idx] + 1; // 다음 탐색을 위해 화살 수 되돌려놓기
    }
    shoot(idx + 1, arrows, ryan, appeach, answer); // 라이언이 화살을 쏘지 않은 경우 (점수 획득 X)
  }

  public int[] solution(int n, int[] info) {
    int[] ryan = new int[11];
    int[] answer = new int[11];
    Arrays.fill(answer, -1);

    shoot(0, n, ryan, info, answer);

    if (answer[0] == -1) {
      int[] neverWin = { -1 };
      return neverWin;
    }

    return answer;
  }
}