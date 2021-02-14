//문제) 문자열 압축
/*
0과 1로만 이루어진 비트열의 경우에는 같은 비트가 연속해서 
등장하는 횟수들을 기록하여 저장공간을 줄일 수 있다.
만약 비트열이 0이 아니라 1로 시작하는 경우에는 저장 공간의 
제일 앞에 1을 붙여서 혼돈을 방지하도록 한다. 
예를 들어, 110100의 경우에는 1BAAB로 표시한다. 
*/

//생각) 입력된 문자열에서 맨 첫 글자 판단 -> for문으로 같은 문자의 개수 세어서 저장

//의문1)문자열에 문자 저장 어떻게? + 로 
//의문2)문자열에서 한 문자씩 어떻게 접근하지? String 클래스의 charAt() 사용 

//주의1)문자 비교 시 비교 문자 ' ' 이렇게 표시!

import java.io.*;

public class Main {
	static String solution(String input){
		String answer=null;
		char count = 'A'; //문자 개수 저장
		char before = input.charAt(0); //이전 문자 저장
		
		//1.첫글자 판단
		if(input.charAt(0)=='1') answer = "1";
	
		//2.같은 문자 개수 세기
		for(int i = 1; i<input.length(); i++){
			if(before != input.charAt(i)){ //다른 문자 등장 시 
        //0으로 시작했는지 확인 
				if(answer == null) answer = String.valueOf(count);
				else answer += count; //문자열&문자 더하기, 이전 문자 개수 저장
				before = input.charAt(i); //이전 문자 리뉴얼
				count = 'A'; //개수 초기화 
			}
			else{ //동일한 문자 등장 시
				count++;
			}
		}

		//3. 1가지 문자만 존재할 경우 & 마지막 문자 개수 처리
		if(answer == null) answer = String.valueOf(count); //0으로 시작한 경우 
		else answer += count;
	
		return answer;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		String answer= solution(input);
		
		System.out.println(answer);
	}
}