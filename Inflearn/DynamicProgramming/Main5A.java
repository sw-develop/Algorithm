import java.util.*;

class Block implements Comparable<Block> {
  int area, height, weight;

  public Block(int area, int height, int weight) {
    this.area = area;
    this.height = height;
    this.weight = weight;
  }

  @Override
  public int compareTo(Block o) {
    return this.area - o.area;
  }
}

public class Main5A {

  public static int solution(int N, List<Block> input) {
    Collections.sort(input); // area 값 기준 오름차순 정렬

    int[] dy = new int[N];
    dy[0] = input.get(0).height;
    int answer = dy[0];

    for (int i = 1; i < N; i++) {
      int max = 0;
      for (int j = i - 1; j >= 0; j--) {
        if (input.get(j).weight < input.get(i).weight && dy[j] > max) {
          max = dy[j];
        }
      }
      dy[i] = max + input.get(i).height;
      answer = Math.max(answer, dy[i]);
    }

    return answer;
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    int N = kbd.nextInt();
    List<Block> input = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      input.add(new Block(kbd.nextInt(), kbd.nextInt(), kbd.nextInt()));
    }
    System.out.println(solution(N, input));
  }
}