import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;
import java.util.Collections;

// 객체 정렬
class StudentInfo implements Comparable<StudentInfo> {
  private String name;
  private int score;

  StudentInfo(String name, int score){
    this.name = name;
    this.score = score;
  }

  public String getName(){
    return this.name;
  }

  public void setName(String name){
    this.name = name;
  }

  public int getScore(){
    return this.score;
  }

  public void setScore(int score){
    this.score = score;
  }

  @Override 
  public int compareTo(StudentInfo s) { // 오름차순 정렬 구현 
    return this.score - s.getScore();
  }
}

public class Q2 {
  public static void main(String[] args){
    Scanner kbd = new Scanner(System.in);

    List<StudentInfo> list = new LinkedList<StudentInfo>(); // StudentInfo 객체 저장할 리스트
 
    int numberOfStudent = kbd.nextInt(); // 학생 수
    for(int i = 0; i < numberOfStudent; i++){
      StudentInfo studentInfo = new StudentInfo(kbd.next(), kbd.nextInt());
      list.add(studentInfo);
    }

    Collections.sort(list);

    for(StudentInfo studentInfo : list)
      System.out.print(studentInfo.getName() + " ");

    kbd.close();
  }
}
