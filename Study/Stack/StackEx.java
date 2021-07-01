import java.util.Stack;

public class StackEx {

	public static void main(String[] args) {
		Stack<Integer> st = new Stack<Integer>(); //스택 생성 
		
		//push()를 이용한 요소 삽입 
		st.push(3);
		st.push(2);
		st.push(1);
		
		//peek()을 이용한 요소의 반환 
		System.out.println(st.peek());
		System.out.println(st); 
		
		//pop()을 이용한 요소의 반환 및 제거 
		System.out.println(st.pop());
		System.out.println(st);
		
		//search()를 이용한 요소의 위치 검색 
		System.out.println(st.search(2));
		System.out.println(st.search(3)); 
	}

}