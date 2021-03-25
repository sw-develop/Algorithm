//Q. 2차원 배열에 학년별로 1,2학기 성적을 저장하여 초기화하고, 4년간 전체 평점 평균 출력하기

public class ArrayEx4{
  public static void main(String[] args){
    double[][] score = {
      {4.3, 4.3},
      {4.3, 4.2},
      {4.3, 4.3},
      {4.3, 4.3}
    }; //2차원 배열 선언, 생성, 초기화

    double sum = 0;
    int year = 0, term = 0;

    //전체 평점, 평균 출력하기
    //행의 크기 : 배열명.length
    //열의 크기 : 배열명[행].length
    for(year = 0; year < score.length; year++)
      for(term=0; term < score[year].length; term++)
        sum += score[year][term]; 

    System.out.println("Total : " + sum);
    System.out.println("Average : " + sum/(year*term));
  }
}