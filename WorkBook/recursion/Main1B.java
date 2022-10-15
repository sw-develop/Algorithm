import java.io.*;

public class Main1B {

  static int N;
  static StringBuilder ans = new StringBuilder();

  public static void print(String str, int cnt) {
    for (int i = 0; i < cnt; i++) {
      ans.append("____");
    }
    ans.append(str);
  }

  public static void solution(int cnt) {
    print("\"재귀함수가 뭔가요?\"\n", cnt);

    if (cnt == N) { // 재귀 끝낼 조건
      print("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n", cnt);
    } else {
      print("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n", cnt);
      print("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n", cnt);
      print("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n", cnt);
      solution(cnt + 1);
    }
    
    print("라고 답변하였지.\n", cnt);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    
    ans.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
    solution(0);
    System.out.println(ans);
  }
}

/*
문제 회고

재귀 함수 구조
a. 재귀 끝낼 조건
b. 재귀 수행

*/