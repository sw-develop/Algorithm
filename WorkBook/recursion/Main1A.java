import java.io.*;

public class Main1A {

  static StringBuilder ans = new StringBuilder();

  public static void print(int cnt) {
    for (int i = 0; i < cnt; i++) {
      ans.append("_");
    }
  }
  
  public static void solution(int N, int cnt) {
    print(cnt);
    ans.append("\"재귀함수가 뭔가요?\"\n");
    
    if (N == 0) { //재귀 끝낼 조건
      print(cnt);
      ans.append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
    } else {
      print(cnt);
      ans.append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
      print(cnt);
      ans.append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
      print(cnt);
      ans.append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
      solution(N - 1, cnt + 4);
    }

    print(cnt);
    ans.append("라고 답변하였지.\n");
  }
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    ans.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");  
    solution(N, 0);
    System.out.println(ans);
  }
}