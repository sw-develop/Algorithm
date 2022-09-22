//정렬 조건
//국어 점수 내림차순
//국어 점수 같으면, 영어 점수 오름차순
//영어 점수 같으면, 수학 점수 내림차순
//수학 점수 같으면, 이름 오름차순

import java.io.*;
import java.util.*;

class Student implements Comparable<Student> {
  String name;
  int kor;
  int eng;
  int math;

  public Student(String name, int kor, int eng, int math) {
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
  }

  @Override
  public int compareTo(Student o) {
    if (o.kor - this.kor == 0) {
      if (this.eng - o.eng == 0) {
        if (o.math - this.math == 0) {
          return this.name.compareTo(o.name); // String 사전순
        }
        return o.math - this.math;
      }
      return this.eng - o.eng;
    }
    return o.kor - this.kor;
  }
}

public class Main6A {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    List<Student> input = new LinkedList<>();
    for (int i = 0; i < N; i++) {
      String[] str = br.readLine().split(" ");
      String name = str[0];
      int kor = Integer.parseInt(str[1]);
      int eng = Integer.parseInt(str[2]);
      int math = Integer.parseInt(str[3]);
      input.add(new Student(name, kor, eng, math));
    }

    Collections.sort(input);
    for (Student s : input) {
      System.out.println(s.name);
    }
  }
}