import java.util.*;

class Student implements Comparable<Student> {
  int height;
  int weight;

  public Student(int height, int weight) {
    this.height = height;
    this.weight = weight;
  }

  @Override
  public int compareTo(Student o) {
    return o.height - this.height;
  }
}

public class Main1A {

  public static int solution(int N, Student[] input) {
    int output = 0;

    Arrays.sort(input); // 내림차순 정렬
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < N; i++) {
      if (input[i].weight > max) {
        max = input[i].weight;
        output++;
      }
    }

    return output;
  }

  public static void main(String[] args) {
    Scanner kbd = new Scanner(System.in);
    int N = kbd.nextInt();
    Student[] input = new Student[N];
    for (int i = 0; i < N; i++) {
      input[i] = new Student(kbd.nextInt(), kbd.nextInt());
    }
    System.out.println(solution(N, input));
  }
}