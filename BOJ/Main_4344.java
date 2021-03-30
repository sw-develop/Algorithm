import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main_4344{
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int testNum = Integer.parseInt(br.readLine()); //테스트 케이스 수
    double[] stu_avg = new double[testNum]; //평균 넘는 학생들 비율 저장 배열 
    int[] score = null;
    StringTokenizer st = null;

    double score_avg = 0; //평균 점수
    int sum = 0;
    int count_stu = 0; //평균을 넘는 학생 수 

    for(int i = 0; i<testNum; i++){
      st = new StringTokenizer(br.readLine(), " ");
      score = new int[Integer.parseInt(st.nextToken())]; //배열의 크기

      //score배열 채우기 
      for(int j = 0; j<score.length; j++){
        score[j] = Integer.parseInt(st.nextToken());
        sum += score[j];
      }
      //평균 구하기
      score_avg = (double)sum/score.length;
      //평균 보다 넘는 학생들의 비율 구하기
      for(int k = 0; k<score.length; k++)
        if(score[k] > score_avg) count_stu++;
      
      stu_avg[i] = (double)count_stu/score.length*100;

      sum = 0;
      count_stu = 0;
    }

    for(int m = 0; m<stu_avg.length; m++)
      System.out.printf("%.3f%%\n", stu_avg[m]);
  }
}