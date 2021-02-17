//문제) 후위표기법

//사용 자료구조 : 스택

//생각) 입력된 문자열 -> 공백 기준 토큰으로 분리 -> 숫자이면 스택에 push & 연산자이면 스택에서 피연산자 2개 pop 해서 연산

//방법1) Stack class 사용
//방법2) 스택 구현

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Stack; //스택 클래스 

public class Main {
	public static int solution(int m, String input) { 
		int answer = 0;
		int n1 = 0, n2 = 0; //피연산자 저장할 변수 
		
		Stack<Integer> s = new Stack<Integer>(); 
		StringTokenizer st = new StringTokenizer(input, " ");
		
		while(st.hasMoreTokens()){ //문자열이 끝날 때까지 반복 
			String val = st.nextToken();
			if(val.equals("+") || val.equals("-") || val.equals("*") || val.equals("/")){ //연산자일 때 
				n2 = s.pop(); //주의) 먼저 pop된 값이 2번째 피연산자임! LIFO 
				n1 = s.pop();
				if(val.equals("+")) answer = n1+n2;
				else if(val.equals("-")) answer = n1-n2;
				else if(val.equals("*")) answer = n1*n2;
				else answer = n1/n2;
				s.push(answer); //스택에 다시 push 
			}
			else //피연산자일 때 
				s.push(Integer.parseInt(val));
		}
		
		answer = s.pop(); //스택에서 최종 값 pop 
		return answer;
	}

	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int m = input.nextInt(); // 연산자 + 피연산자 수 
		input.nextLine(); //주의) enter 값 제거 
		String str = input.nextLine();
		int result;
		
		result=solution(m, str);
		System.out.println(result);
		
		
	}
}
