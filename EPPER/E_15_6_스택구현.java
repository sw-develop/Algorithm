//Array Stack
class Stack{ //스택에 필요한 변수 & 메서드 구현
    private int top; //가장 최근 원소 위치 가리키는 변수
    private int stackSize; //스택 크기
    private int stackArr[]; //배열 선언

    //예외처리1)empty stack 예외 처리
    class EmptyStackException extends RuntimeException{
      public EmptyStackException(){
        //아마 super(); 을 하는 듯 -> 찾아보기! 
      }
    }

    //예외처리2)full stack 예외 처리 
    class OverflowStackException extends RuntimeException{
      public OverflowStackException(){}
    }

    //생성자
    public Stack(int stackSize){ 
      top = -1; 
      this.stackSize = stackSize;
      try{
        stackArr = new int[stackSize]; //배열 생성 
      }catch(OutOfMemoryError e){
        this.stackSize = 0;
      }
    }

    public boolean isFull() {return (top+1)==stackSize;}
    public boolean isEmpty() {return top==-1;}

    public void push(int data) throws OverflowStackException{
      //풀 스택일 때
      if(isFull()) throw new OverflowStackException();
      else stackArr[++top] = data;
    }

    public int pop() throws EmptyStackException{
      //빈 스택일 때
      if(isEmpty()) throw new EmptyStackException(); 
      return stackArr[top--];
    }

    public int peek() throws EmptyStackException{
      //빈 스택일 때
      if(isEmpty()) throw new EmptyStackException();
      return stackArr[top];
    }

    public void printStack(){
      System.out.println("Stack List : ");
      for(int i = top; i>=0; i--)
        System.out.printf("%d ", stackArr[i]);
      System.out.println();
    }
  }

public class E_15_6_스택구현{
  public static void main(String[] args){
    Stack st = new Stack(3);

    st.push(1);
    st.push(2);
    st.push(3);
    try{
      st.push(4);
    }catch(Stack.OverflowStackException e){
      System.out.println("Stack is full");
    }
    
    st.printStack();

    st.pop();
    st.pop();

    st.printStack();

  }
}