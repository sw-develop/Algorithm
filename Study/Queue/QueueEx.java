import java.util.LinkedList;

public class QueueEx {

	public static void main(String[] args) {
		LinkedList<String> qu = new LinkedList<String>(); //큐 생성 
		
		//add()를 이용한 요소의 저장 
		qu.add("h");
		qu.add("e");
		qu.add("l");
		qu.add("l");
		qu.add("o");
		
		//peek()을 이용한 요소의 반환 
		System.out.println(qu.peek());
		System.out.println(qu);
		
		//poll()을 이용한 요소의 반환 및 제거
		System.out.println(qu.poll());
		System.out.println(qu);
		
		//remove() 메소드를 이용한 특정한 요소의 제거 
		qu.remove("l");
		System.out.println(qu);		
	}
}