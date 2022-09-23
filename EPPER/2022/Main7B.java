import java.util.Arrays;

class Solution {

  static int maxDiff = 0; // 최대 점수 차이

  public static boolean compare(int[] ryan, int[] answer) {
    // 가장 낮은 점수를 현재 경우가 더 많이 맞혔을 경우 true 반환
    for (int i = 10; i >= 0; i--) {
      if (ryan[i] > answer[i]) {
        return true;
      } else if (ryan[i] < answer[i]) {
        return false;
      }
    }
    return false;
  }

  public static void calcScore(int[] ryan, int[] appeach, int[] answer) {
    // 라이언과 어피치의 최종 점수 계산
    int ryanScore = 0, appeachScore = 0;
    for (int i = 0; i < 11; i++) {
      if (ryan[i] > appeach[i]) { // 라이언이 점수 획득
        ryanScore += 10 - i;
      } else if (appeach[i] > 0) { // 어피치가 점수 획득
        appeachScore += 10 - i;
      }
    }
    int diff = ryanScore - appeachScore;
    // answer 업데이트
    if (diff > 0 && diff >= maxDiff) {
      // 동일한 점수 차이일 때
      if (diff == maxDiff) {
        // 가장 낮은 점수를 어떤 경우가 더 많이 맞혔는지 확인
        // 반환값 true : 업데이트 필요, false : 업데이트 X
        if (!compare(ryan, answer)) {
          return;
        }
      }
      // answer 업데이트
      maxDiff = diff; // 이거 놓침..!!
      for (int i = 0; i < 11; i++) {
        answer[i] = ryan[i];
      }
    }

  }

  public static void dfs(int arrows, int idx, int[] ryan, int[] appeach, int[] answer) {
    // 1.(해당 경우에 대한) 재귀 끝낼 조건
    // arrows == 0 || idx == 11
    if (arrows == 0 || idx == 11) {
      // 최종점수 계산 및 answer 업데이트
      ryan[10] += arrows; // 남은 화살 처리 - 가장 낮은 점수에 맞힌 것으로 함
      calcScore(ryan, appeach, answer);
      ryan[10] -= arrows; // 다음 탐색을 위해 화살 처리 취소
      return;
    }

    // 2.재귀 수행
    // 라이언이 해당 점수 획득
    if (arrows > appeach[idx]) {
      ryan[idx] += appeach[idx] + 1; // 라이언 점수판 업데이트
      dfs(arrows - appeach[idx] - 1, idx + 1, ryan, appeach, answer);
      ryan[idx] -= appeach[idx] + 1; // 다음 탐색을 위해 라이언 점수판 업데이트 취소
    }
    // 라이언이 해당 점수 획득 X
    dfs(arrows, idx + 1, ryan, appeach, answer);
  }

  public int[] solution(int n, int[] info) {
    // n : 화살 개수, info : 어피치가 각 점수에 쏜 화살의 개수

    int[] answer = new int[11];
    Arrays.fill(answer, -1);

    int[] ryan = new int[11]; // 라이언의 점수판
    dfs(n, 0, ryan, info, answer);

    if (answer[0] == -1) { // 라이언이 우승할 방법이 없는 경우
      int[] neverWin = { -1 };
      return neverWin;
    }

    return answer;
  }
}