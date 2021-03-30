//비정방형 배열

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main_4344{
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[][] score = new int[Integer.parseInt(br.readLine())][]; //학생 점수 저장 2차원 비정방형 배열  
    double[] stu_avg = new double[score.length]; //평균 넘는 학생들 비율 저장 배열 
    StringTokenizer st = null;

    double score_avg = 0; //평균 점수
    int sum = 0;
    int count_stu = 0; //평균을 넘는 학생 수 

    for(int i = 0; i<score.length; i++){
      st = new StringTokenizer(br.readLine(), " ");
      score[i] = new int[Integer.parseInt(st.nextToken())]; //1차원 배열 생성 
      for(int j = 0; j<score[i].length; j++){
        //배열 채우기
        score[i][j] = Integer.parseInt(st.nextToken());
        sum += score[i][j];
      }
      //평균 구하기
      score_avg = (double)sum/score[i].length;
      //평균 보다 넘는 학생들의 비율 구하기
      for(int k = 0; k<score[i].length; k++){
        if(score[i][k] > score_avg) count_stu++;
      }
      stu_avg[i] = (double)count_stu/score[i].length*100;

      sum = 0;
      count_stu = 0;
    }

    for(int m = 0; m<score.length; m++)
      System.out.printf("%.3f%%\n", stu_avg[m]);
  }
}